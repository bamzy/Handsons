.class public Lcom/drms/drms_drone/Controller/DroneController/Setting2View;
.super Landroid/view/View;
.source "Setting2View.java"


# static fields
.field public static final REQUEST_DUAL1_JOYSTICK:Ljava/lang/String; = "request dual1"

.field public static final REQUEST_DUAL2_JOYSTICK:Ljava/lang/String; = "request dual2"

.field public static final REQUEST_SINGLE_JOYSTICK:Ljava/lang/String; = "request single"

.field private static final TAG:Ljava/lang/String; = "Setting1View"


# instance fields
.field private activity:Landroid/app/Activity;

.field private context:Landroid/content/Context;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private x:F

.field private y:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 40
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    .line 41
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->activity:Landroid/app/Activity;

    .line 42
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 44
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 45
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 12
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v11, 0x420c0000    # 35.0f

    const/high16 v10, 0x41c80000    # 25.0f

    const/4 v9, 0x1

    const/high16 v8, 0x40000000    # 2.0f

    const/4 v7, 0x0

    .line 49
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 51
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 52
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x50

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    .line 53
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2d

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    .line 54
    const-string v0, "Setting1View"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "x : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\ny : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 56
    :cond_0
    const/16 v0, 0xa

    new-array v6, v0, [Landroid/graphics/Paint;

    .line 58
    .local v6, "set1Paint":[Landroid/graphics/Paint;
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    aput-object v0, v6, v7

    .line 59
    aget-object v0, v6, v7

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 60
    aget-object v0, v6, v7

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 61
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 62
    aget-object v0, v6, v7

    const/high16 v1, 0x40800000    # 4.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 63
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 66
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 67
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 68
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 69
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 70
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 72
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 73
    const-string v0, "\ube44\ud589 \uc18d\ub3c4"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x40c00000    # 6.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 74
    aget-object v0, v6, v7

    const/high16 v1, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 75
    const-string v0, "\ub9e4\uc6b0 \ub290\ub9bc"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 76
    const-string v0, "\ub290\ub9bc"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 77
    const-string v0, "\uc911\uac04"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 78
    const-string v0, "\ube60\ub984"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 79
    const-string v0, "\ub9e4\uc6b0 \ube60\ub984"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 81
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 82
    aget-object v0, v6, v7

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0052

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 84
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    aput-object v0, v6, v9

    .line 85
    aget-object v0, v6, v9

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 88
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    const/16 v1, 0x64

    if-ne v0, v1, :cond_4

    .line 89
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 90
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 91
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 92
    const-string v0, "\ub9e4\uc6b0 \ub290\ub9bc"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 120
    :cond_1
    :goto_0
    aget-object v0, v6, v7

    const/high16 v1, 0x40800000    # 4.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 121
    aget-object v0, v6, v7

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 122
    const-string v0, "\ud2b8\ub9bc \uc870\uc815 \uac04\uaca9 "

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41800000    # 16.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 124
    aget-object v0, v6, v7

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 125
    aget-object v0, v6, v7

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 126
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 127
    aget-object v0, v6, v7

    const/high16 v1, 0x40800000    # 4.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 128
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 131
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 132
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 133
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 134
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 135
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 137
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 138
    aget-object v0, v6, v7

    const/high16 v1, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 139
    const-string v0, "1"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 140
    const-string v0, "2"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 141
    const-string v0, "3"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 142
    const-string v0, "4"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 143
    const-string v0, "5"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 145
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 146
    aget-object v0, v6, v7

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0052

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 148
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    aput-object v0, v6, v9

    .line 149
    aget-object v0, v6, v9

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 152
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    if-ne v0, v9, :cond_8

    .line 153
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 154
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 155
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 156
    const-string v0, "1"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 184
    :cond_2
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    if-ne v0, v9, :cond_3

    .line 185
    aget-object v0, v6, v7

    const/high16 v1, 0x40800000    # 4.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 186
    aget-object v0, v6, v7

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 187
    const-string v0, "\uc2a4\ub9c8\ud2b8\ud3f0 \ucd5c\ub300 \uae30\uc6b8\uae30"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41f80000    # 31.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 189
    aget-object v0, v6, v7

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 190
    aget-object v0, v6, v7

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 191
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 192
    aget-object v0, v6, v7

    const/high16 v1, 0x40800000    # 4.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 193
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 196
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 197
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 198
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 199
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 200
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 202
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 203
    aget-object v0, v6, v7

    const/high16 v1, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 204
    const-string v0, "30\u02da"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 205
    const-string v0, "40\u02da"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 206
    const-string v0, "50\u02da"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 207
    const-string v0, "60\u02da"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 208
    const-string v0, "70\u02da"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 210
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 211
    aget-object v0, v6, v7

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0052

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 213
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    aput-object v0, v6, v9

    .line 214
    aget-object v0, v6, v9

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 217
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v0

    const/16 v1, 0x1e

    if-ne v0, v1, :cond_c

    .line 218
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v10, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 219
    const/high16 v0, 0x41700000    # 15.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 220
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 221
    const-string v0, "30\u02da"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 246
    :cond_3
    :goto_2
    return-void

    .line 94
    :cond_4
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_5

    .line 95
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 96
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 97
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 98
    const-string v0, "\ub290\ub9bc"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 101
    :cond_5
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    const/16 v1, 0x12c

    if-ne v0, v1, :cond_6

    .line 102
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 103
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 104
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 105
    const-string v0, "\uc911\uac04"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 107
    :cond_6
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    const/16 v1, 0x15e

    if-ne v0, v1, :cond_7

    .line 108
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 109
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 110
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 111
    const-string v0, "\ube60\ub984"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 113
    :cond_7
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v0

    const/16 v1, 0x190

    if-ne v0, v1, :cond_1

    .line 114
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 115
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41000000    # 8.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41500000    # 13.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 116
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 117
    const-string v0, "\ub9e4\uc6b0 \ube60\ub984"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41280000    # 10.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 158
    :cond_8
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_9

    .line 159
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 160
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 161
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 162
    const-string v0, "2"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 165
    :cond_9
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_a

    .line 166
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 167
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 168
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 169
    const-string v0, "3"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 171
    :cond_a
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_b

    .line 172
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 173
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 174
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 175
    const-string v0, "4"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 177
    :cond_b
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getTreamInterval()I

    move-result v0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_2

    .line 178
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 179
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x41e00000    # 28.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 180
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 181
    const-string v0, "5"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x41cc0000    # 25.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 222
    :cond_c
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v0

    const/16 v1, 0x28

    if-ne v0, v1, :cond_d

    .line 223
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v10, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 224
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v10

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 225
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 226
    const-string v0, "40\u02da"

    const/high16 v1, 0x41f00000    # 30.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_2

    .line 227
    :cond_d
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v0

    const/16 v1, 0x32

    if-ne v0, v1, :cond_e

    .line 228
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 229
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v11

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42340000    # 45.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 230
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 231
    const-string v0, "50\u02da"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_2

    .line 232
    :cond_e
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v0

    const/16 v1, 0x3c

    if-ne v0, v1, :cond_f

    .line 233
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 234
    const/high16 v0, 0x42340000    # 45.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x425c0000    # 55.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 235
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 236
    const-string v0, "60\u02da"

    const/high16 v1, 0x42480000    # 50.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_2

    .line 237
    :cond_f
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v0

    const/16 v1, 0x46

    if-ne v0, v1, :cond_3

    .line 238
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v7

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 239
    const/high16 v0, 0x425c0000    # 55.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v7

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v8

    add-float/2addr v1, v0

    const/high16 v0, 0x42180000    # 38.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v2

    aget-object v2, v6, v7

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v8

    add-float/2addr v2, v0

    const/high16 v0, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v8

    sub-float v3, v0, v3

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v7

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 240
    aget-object v0, v6, v7

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 241
    const-string v0, "70\u02da"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42220000    # 40.5f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v8

    add-float/2addr v2, v3

    aget-object v3, v6, v7

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_2
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/high16 v8, 0x425c0000    # 55.0f

    const/high16 v7, 0x42340000    # 45.0f

    const/high16 v6, 0x420c0000    # 35.0f

    const/high16 v5, 0x41c80000    # 25.0f

    const/4 v4, 0x0

    .line 250
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_f

    .line 251
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 252
    .local v0, "joystickIntent":Landroid/content/Intent;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x41700000    # 15.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpg-float v1, v1, v2

    if-gez v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41000000    # 8.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41500000    # 13.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_0

    .line 253
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x64

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 254
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 255
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 258
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41000000    # 8.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41500000    # 13.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_1

    .line 259
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0xc8

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 260
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 261
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 264
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpg-float v1, v1, v2

    if-gez v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41000000    # 8.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41500000    # 13.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_2

    .line 265
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x12c

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 266
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 267
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 270
    :cond_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpg-float v1, v1, v2

    if-gez v1, :cond_3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41000000    # 8.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41500000    # 13.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_3

    .line 271
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x15e

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 272
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 273
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 276
    :cond_3
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gez v1, :cond_4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41000000    # 8.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_4

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41500000    # 13.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_4

    .line 277
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x190

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setDRONE_SPEED(I)V

    .line 278
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 279
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 282
    :cond_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x41700000    # 15.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpg-float v1, v1, v2

    if-gez v1, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_5

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41e00000    # 28.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_5

    .line 283
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setTreamInterval(I)V

    .line 284
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 285
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 288
    :cond_5
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gez v1, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_6

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41e00000    # 28.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_6

    .line 289
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setTreamInterval(I)V

    .line 290
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 291
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 294
    :cond_6
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpg-float v1, v1, v2

    if-gez v1, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_7

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41e00000    # 28.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_7

    .line 295
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setTreamInterval(I)V

    .line 296
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 297
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 300
    :cond_7
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpg-float v1, v1, v2

    if-gez v1, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_8

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41e00000    # 28.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_8

    .line 301
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setTreamInterval(I)V

    .line 302
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 303
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 306
    :cond_8
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gez v1, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41b80000    # 23.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_9

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x41e00000    # 28.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_9

    .line 307
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setTreamInterval(I)V

    .line 308
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 309
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 312
    :cond_9
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_e

    .line 313
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x41700000    # 15.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpg-float v1, v1, v2

    if-gez v1, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x42180000    # 38.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_a

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x422c0000    # 43.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_a

    .line 314
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x1e

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setSmartphoneAngle(I)V

    .line 315
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 316
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 319
    :cond_a
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gez v1, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x42180000    # 38.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_b

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x422c0000    # 43.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_b

    .line 320
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x28

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setSmartphoneAngle(I)V

    .line 321
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 322
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 325
    :cond_b
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v6

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpg-float v1, v1, v2

    if-gez v1, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x42180000    # 38.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_c

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x422c0000    # 43.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_c

    .line 326
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x32

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setSmartphoneAngle(I)V

    .line 327
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 328
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 331
    :cond_c
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v7

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpg-float v1, v1, v2

    if-gez v1, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x42180000    # 38.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_d

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x422c0000    # 43.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_d

    .line 332
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x3c

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setSmartphoneAngle(I)V

    .line 333
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 334
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 337
    :cond_d
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v8

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x42820000    # 65.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->x:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gez v1, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x42180000    # 38.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_e

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    const/high16 v2, 0x422c0000    # 43.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->y:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_e

    .line 338
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/16 v2, 0x46

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setSmartphoneAngle(I)V

    .line 339
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 340
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->invalidate()V

    .line 343
    :cond_e
    const-string v1, "Setting1View"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "drone speed : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 345
    .end local v0    # "joystickIntent":Landroid/content/Intent;
    :cond_f
    const/4 v1, 0x1

    return v1
.end method
