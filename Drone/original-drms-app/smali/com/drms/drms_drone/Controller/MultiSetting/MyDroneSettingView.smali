.class public Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;
.super Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;
.source "MyDroneSettingView.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "MyDroneSettingView"


# instance fields
.field private positionXGraph:[F

.field private positionYGraph:[F

.field private settingPath:[Landroid/graphics/Path;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    const/16 v2, 0x9

    .line 30
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    .line 25
    new-array v1, v2, [Landroid/graphics/Path;

    iput-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    .line 26
    const/4 v1, 0x3

    new-array v1, v1, [F

    iput-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    .line 27
    new-array v1, v2, [F

    iput-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    .line 33
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 34
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    new-instance v2, Landroid/graphics/Path;

    invoke-direct {v2}, Landroid/graphics/Path;-><init>()V

    aput-object v2, v1, v0

    .line 33
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 38
    :cond_0
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 42
    invoke-super {p0, p1}, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;->onDraw(Landroid/graphics/Canvas;)V

    .line 44
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasWidth:F

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v1

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasHeight:F

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v1

    int-to-float v1, v1

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_1

    .line 45
    :cond_0
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasWidth:F

    .line 46
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasHeight:F

    .line 48
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasWidth:F

    const/high16 v1, 0x42820000    # 65.0f

    div-float/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    .line 49
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->canvasHeight:F

    const/high16 v1, 0x42200000    # 40.0f

    div-float/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    .line 51
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 52
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 53
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 55
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 56
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 57
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x5

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 59
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 60
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 61
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 63
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 64
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 65
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x2

    const/high16 v2, 0x42300000    # 44.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 66
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x0

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 67
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x1

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 68
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 69
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x3

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 70
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x4

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 71
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x5

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 72
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x6

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 73
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v1, 0x7

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 74
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/16 v1, 0x8

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 76
    const-string v0, "MyDroneSettingView"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "x : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/ y : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :cond_1
    const/16 v0, 0xa

    new-array v11, v0, [Landroid/graphics/Paint;

    .line 82
    .local v11, "myDronePaint":[Landroid/graphics/Paint;
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f030029

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v13

    .line 83
    .local v13, "temp":Landroid/graphics/Bitmap;
    const/high16 v0, 0x41200000    # 10.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v0, v1

    invoke-virtual {v13}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    int-to-float v1, v1

    div-float v12, v0, v1

    .line 84
    .local v12, "scale":F
    invoke-virtual {v13}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v12

    float-to-int v0, v0

    invoke-virtual {v13}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    int-to-float v1, v1

    mul-float/2addr v1, v12

    float-to-int v1, v1

    const/4 v2, 0x1

    invoke-static {v13, v0, v1, v2}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 85
    .local v10, "myDrone":Landroid/graphics/Bitmap;
    const/high16 v0, 0x40a00000    # 5.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v0, v1

    const/high16 v1, 0x40a00000    # 5.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {p1, v10, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 89
    const/4 v0, 0x0

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 90
    const/4 v0, 0x0

    aget-object v0, v11, v0

    const/high16 v1, 0x40e00000    # 7.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 91
    const/4 v0, 0x0

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0028

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 92
    const/4 v0, 0x0

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 94
    const/high16 v0, 0x41a00000    # 20.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41880000    # 17.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 95
    const/high16 v0, 0x420c0000    # 35.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41880000    # 17.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 96
    const/high16 v0, 0x42480000    # 50.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42700000    # 60.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41880000    # 17.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 98
    const/4 v0, 0x1

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 99
    const/4 v0, 0x1

    aget-object v0, v11, v0

    const/high16 v1, 0x41000000    # 8.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 100
    const/4 v0, 0x1

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 101
    const/4 v0, 0x1

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 102
    const/4 v0, 0x1

    aget-object v0, v11, v0

    const/high16 v1, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 104
    const-string v0, "Acc"

    const/high16 v1, 0x41c80000    # 25.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const-wide/high16 v2, 0x401a000000000000L    # 6.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 105
    const-string v0, "Gyro"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const-wide/high16 v2, 0x401a000000000000L    # 6.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 106
    const-string v0, "Orient"

    const/high16 v1, 0x425c0000    # 55.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const-wide/high16 v2, 0x401a000000000000L    # 6.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 108
    const/4 v0, 0x1

    aget-object v0, v11, v0

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 109
    const/4 v0, 0x1

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 111
    const-string v0, "x"

    const-wide v2, 0x4035800000000000L    # 21.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 112
    const-string v0, "y"

    const-wide v2, 0x4035800000000000L    # 21.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 113
    const-string v0, "z"

    const-wide v2, 0x4035800000000000L    # 21.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 115
    const-string v0, "x"

    const-wide v2, 0x4042400000000000L    # 36.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 116
    const-string v0, "y"

    const-wide v2, 0x4042400000000000L    # 36.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 117
    const-string v0, "z"

    const-wide v2, 0x4042400000000000L    # 36.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 119
    const-string v0, "R"

    const-wide v2, 0x4049c00000000000L    # 51.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 120
    const-string v0, "P"

    const-wide v2, 0x4049c00000000000L    # 51.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 121
    const-string v0, "Y"

    const-wide v2, 0x4049c00000000000L    # 51.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    const/4 v4, 0x1

    aget-object v4, v11, v4

    invoke-virtual {v4}, Landroid/graphics/Paint;->getTextSize()F

    move-result v4

    const/high16 v5, 0x40000000    # 2.0f

    div-float/2addr v4, v5

    float-to-double v4, v4

    add-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x1

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 123
    const/4 v0, 0x2

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 127
    const/4 v0, 0x0

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 128
    const/4 v0, 0x0

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0001

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 130
    const/high16 v0, 0x40000000    # 2.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x41a80000    # 21.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 131
    const/high16 v0, 0x41b80000    # 23.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42280000    # 42.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 132
    const/high16 v0, 0x42300000    # 44.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x427c0000    # 63.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 134
    const/4 v0, 0x0

    aget-object v0, v11, v0

    const/high16 v1, 0x41200000    # 10.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 135
    const/4 v0, 0x0

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 136
    const/4 v0, 0x0

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0028

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 137
    const/high16 v0, 0x40000000    # 2.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x41a80000    # 21.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 138
    const/high16 v0, 0x41b80000    # 23.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42280000    # 42.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 139
    const/high16 v0, 0x42300000    # 44.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x427c0000    # 63.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x0

    aget-object v5, v11, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 141
    const/4 v0, 0x2

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 142
    const/4 v0, 0x2

    aget-object v0, v11, v0

    const/high16 v1, 0x40c00000    # 6.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 143
    const/4 v0, 0x2

    aget-object v0, v11, v0

    const-wide/high16 v2, 0x3ff8000000000000L    # 1.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 144
    const/4 v0, 0x2

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0028

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 145
    const/4 v0, 0x2

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 147
    new-instance v7, Ljava/text/DecimalFormat;

    const-string v0, "#.##"

    invoke-direct {v7, v0}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 148
    .local v7, "form":Ljava/text/DecimalFormat;
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x0

    aget v0, v0, v1

    int-to-float v0, v0

    const/high16 v1, 0x42480000    # 50.0f

    div-float/2addr v0, v1

    float-to-double v0, v0

    invoke-virtual {v7, v0, v1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x403a800000000000L    # 26.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 149
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x1

    aget v0, v0, v1

    int-to-float v0, v0

    const/high16 v1, 0x42480000    # 50.0f

    div-float/2addr v0, v1

    float-to-double v0, v0

    invoke-virtual {v7, v0, v1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x403a800000000000L    # 26.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 150
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x2

    aget v0, v0, v1

    int-to-float v0, v0

    const/high16 v1, 0x42480000    # 50.0f

    div-float/2addr v0, v1

    float-to-double v0, v0

    invoke-virtual {v7, v0, v1}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x403a800000000000L    # 26.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 152
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x3

    aget v0, v0, v1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x4044c00000000000L    # 41.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 153
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x4

    aget v0, v0, v1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x4044c00000000000L    # 41.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 154
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x5

    aget v0, v0, v1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x4044c00000000000L    # 41.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 156
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v0

    const/4 v1, 0x0

    aget v0, v0, v1

    float-to-int v0, v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x404c400000000000L    # 56.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4021000000000000L    # 8.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 157
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v0

    const/4 v1, 0x1

    aget v0, v0, v1

    float-to-int v0, v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x404c400000000000L    # 56.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x4027000000000000L    # 11.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 158
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v0

    const/4 v1, 0x2

    aget v0, v0, v1

    float-to-int v0, v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v0

    const-wide v2, 0x404c400000000000L    # 56.5

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    float-to-double v4, v1

    mul-double/2addr v2, v4

    double-to-float v1, v2

    const-wide/high16 v2, 0x402d000000000000L    # 14.5

    iget v4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    float-to-double v4, v4

    mul-double/2addr v2, v4

    double-to-float v2, v2

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 160
    const/4 v0, 0x2

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 161
    const-string v0, "Acc"

    const/high16 v1, 0x41400000    # 12.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41b00000    # 22.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 162
    const-string v0, "Gyro"

    const/high16 v1, 0x42040000    # 33.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41b00000    # 22.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 163
    const-string v0, "Orient"

    const/high16 v1, 0x42580000    # 54.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41b00000    # 22.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    sub-float/2addr v2, v3

    const/4 v3, 0x2

    aget-object v3, v11, v3

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 165
    const/4 v0, 0x3

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 166
    const/4 v0, 0x4

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 167
    const/4 v0, 0x5

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v11, v0

    .line 169
    const/4 v0, 0x3

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0029

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 170
    const/4 v0, 0x4

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c004c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 171
    const/4 v0, 0x5

    aget-object v0, v11, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c003f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 173
    const/4 v0, 0x3

    aget-object v0, v11, v0

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 174
    const/4 v0, 0x3

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 176
    const/4 v0, 0x4

    aget-object v0, v11, v0

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 177
    const/4 v0, 0x4

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 179
    const/4 v0, 0x5

    aget-object v0, v11, v0

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 180
    const/4 v0, 0x5

    aget-object v0, v11, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 182
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_c

    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x0

    aget v0, v0, v1

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x1

    aget v0, v0, v1

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v0

    const/4 v1, 0x2

    aget v0, v0, v1

    if-eqz v0, :cond_c

    .line 184
    :cond_2
    const/4 v0, 0x3

    new-array v6, v0, [F

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x3

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 185
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    div-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v6, v0

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x4

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 186
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    div-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v6, v0

    const/4 v0, 0x2

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x5

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 187
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x2

    aget v2, v2, v3

    add-int/lit16 v2, v2, -0x1ea

    div-int/lit8 v2, v2, 0x5

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v6, v0

    .line 190
    .local v6, "acc_temp":[F
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_0
    array-length v0, v6

    if-ge v9, v0, :cond_5

    .line 191
    aget v0, v6, v9

    const/high16 v1, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    aget-object v2, v11, v2

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    add-float/2addr v1, v2

    cmpg-float v0, v0, v1

    if-gez v0, :cond_3

    const/high16 v0, 0x41b00000    # 22.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v0, v1

    const/4 v1, 0x0

    aget-object v1, v11, v1

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    sub-float/2addr v0, v1

    aput v0, v6, v9

    .line 192
    :cond_3
    aget v0, v6, v9

    const/high16 v1, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    aget-object v2, v11, v2

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    cmpl-float v0, v0, v1

    if-lez v0, :cond_4

    const/high16 v0, 0x42180000    # 38.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v0, v1

    const/4 v1, 0x0

    aget-object v1, v11, v1

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    sub-float/2addr v0, v1

    aput v0, v6, v9

    .line 190
    :cond_4
    add-int/lit8 v9, v9, 0x1

    goto :goto_0

    .line 195
    :cond_5
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x0

    aget v1, v1, v2

    const/4 v2, 0x0

    aget v2, v6, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 196
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x0

    aget v1, v1, v2

    const/4 v2, 0x1

    aget v2, v6, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 197
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x0

    aget v3, v1, v2

    const/high16 v4, 0x40400000    # 3.0f

    add-float/2addr v3, v4

    aput v3, v1, v2

    const/4 v1, 0x2

    aget v1, v6, v1

    invoke-virtual {v0, v3, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 199
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    const/high16 v1, 0x41a80000    # 21.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_6

    .line 200
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 201
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 203
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 204
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 206
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 207
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    const/high16 v1, 0x40000000    # 2.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 209
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x0

    const/high16 v2, 0x40000000    # 2.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 211
    :cond_6
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    const/4 v1, 0x3

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 212
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x1

    aget-object v0, v0, v1

    const/4 v1, 0x4

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 213
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x2

    aget-object v0, v0, v1

    const/4 v1, 0x5

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 215
    const/4 v0, 0x3

    new-array v8, v0, [F

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x3

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 216
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x3

    aget v2, v2, v3

    div-int/lit8 v2, v2, 0x7

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v8, v0

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x4

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 217
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x4

    aget v2, v2, v3

    div-int/lit8 v2, v2, 0x7

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v8, v0

    const/4 v0, 0x2

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x5

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 218
    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getIMUdata()[I

    move-result-object v2

    const/4 v3, 0x5

    aget v2, v2, v3

    div-int/lit8 v2, v2, 0x7

    int-to-float v2, v2

    sub-float/2addr v1, v2

    aput v1, v8, v0

    .line 221
    .local v8, "gyro_temp":[F
    const/4 v9, 0x0

    :goto_1
    array-length v0, v8

    if-ge v9, v0, :cond_9

    .line 222
    aget v0, v8, v9

    const/high16 v1, 0x41b00000    # 22.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    aget-object v2, v11, v2

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    add-float/2addr v1, v2

    cmpg-float v0, v0, v1

    if-gez v0, :cond_7

    const/high16 v0, 0x41b00000    # 22.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v0, v1

    const/4 v1, 0x0

    aget-object v1, v11, v1

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    sub-float/2addr v0, v1

    aput v0, v8, v9

    .line 223
    :cond_7
    aget v0, v8, v9

    const/high16 v1, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v1, v2

    const/4 v2, 0x0

    aget-object v2, v11, v2

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    sub-float/2addr v1, v2

    cmpl-float v0, v0, v1

    if-lez v0, :cond_8

    const/high16 v0, 0x42180000    # 38.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v0, v1

    const/4 v1, 0x0

    aget-object v1, v11, v1

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    const/high16 v2, 0x40000000    # 2.0f

    div-float/2addr v1, v2

    sub-float/2addr v0, v1

    aput v0, v8, v9

    .line 221
    :cond_8
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 226
    :cond_9
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x1

    aget v1, v1, v2

    const/4 v2, 0x0

    aget v2, v8, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 227
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x1

    aget v1, v1, v2

    const/4 v2, 0x1

    aget v2, v8, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 228
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x5

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x1

    aget v3, v1, v2

    const/high16 v4, 0x40400000    # 3.0f

    add-float/2addr v3, v4

    aput v3, v1, v2

    const/4 v1, 0x2

    aget v1, v8, v1

    invoke-virtual {v0, v3, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 230
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x1

    aget v0, v0, v1

    const/high16 v1, 0x42280000    # 42.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_a

    .line 231
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 232
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 234
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 235
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 237
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x5

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 238
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x5

    aget-object v0, v0, v1

    const/high16 v1, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 240
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 243
    :cond_a
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x3

    aget-object v0, v0, v1

    const/4 v1, 0x3

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 244
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x4

    aget-object v0, v0, v1

    const/4 v1, 0x4

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 245
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x5

    aget-object v0, v0, v1

    const/4 v1, 0x5

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 247
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x2

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v3, 0x3

    aget v2, v2, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v3

    const/4 v4, 0x0

    aget v3, v3, v4

    sub-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 248
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x2

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v3, 0x4

    aget v2, v2, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v3

    const/4 v4, 0x1

    aget v3, v3, v4

    sub-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->lineTo(FF)V

    .line 249
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v2, 0x2

    aget v3, v1, v2

    const/high16 v4, 0x40400000    # 3.0f

    add-float/2addr v3, v4

    aput v3, v1, v2

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionYGraph:[F

    const/4 v2, 0x5

    aget v1, v1, v2

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAttitudeData()[F

    move-result-object v2

    const/4 v4, 0x2

    aget v2, v2, v4

    sub-float/2addr v1, v2

    invoke-virtual {v0, v3, v1}, Landroid/graphics/Path;->lineTo(FF)V

    .line 250
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x2

    aget v0, v0, v1

    const/high16 v1, 0x427c0000    # 63.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    cmpl-float v0, v0, v1

    if-ltz v0, :cond_b

    .line 251
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 252
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 254
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 255
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 257
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    invoke-virtual {v0}, Landroid/graphics/Path;->reset()V

    .line 258
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    const/high16 v1, 0x42300000    # 44.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f00000    # 30.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->y:F

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Path;->moveTo(FF)V

    .line 260
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->positionXGraph:[F

    const/4 v1, 0x2

    const/high16 v2, 0x42300000    # 44.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->x:F

    mul-float/2addr v2, v3

    aput v2, v0, v1

    .line 263
    :cond_b
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x6

    aget-object v0, v0, v1

    const/4 v1, 0x3

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 264
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/4 v1, 0x7

    aget-object v0, v0, v1

    const/4 v1, 0x4

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 265
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->settingPath:[Landroid/graphics/Path;

    const/16 v1, 0x8

    aget-object v0, v0, v1

    const/4 v1, 0x5

    aget-object v1, v11, v1

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawPath(Landroid/graphics/Path;Landroid/graphics/Paint;)V

    .line 272
    .end local v6    # "acc_temp":[F
    .end local v8    # "gyro_temp":[F
    .end local v9    # "i":I
    :cond_c
    return-void
.end method
