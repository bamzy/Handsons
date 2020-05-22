.class public Lcom/drms/drms_drone/Controller/DroneController/Setting1View;
.super Landroid/view/View;
.source "Setting1View.java"


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
    .line 42
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 43
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->activity:Landroid/app/Activity;

    .line 45
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 47
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 48
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v13, 0x41200000    # 10.0f

    const/high16 v12, 0x40a00000    # 5.0f

    const/high16 v11, 0x41f00000    # 30.0f

    const/high16 v10, 0x40000000    # 2.0f

    const/4 v9, 0x0

    .line 52
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 54
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 55
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x50

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    .line 56
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2d

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    .line 57
    const-string v0, "Setting1View"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "x : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\ny : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 59
    :cond_0
    const/16 v0, 0xa

    new-array v6, v0, [Landroid/graphics/Paint;

    .line 61
    .local v6, "set1Paint":[Landroid/graphics/Paint;
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    aput-object v0, v6, v9

    .line 62
    aget-object v0, v6, v9

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 63
    aget-object v0, v6, v9

    invoke-virtual {v0, v12}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 64
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 65
    aget-object v0, v6, v9

    const/high16 v1, 0x40c00000    # 6.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 66
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Align;->CENTER:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 68
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v1, v13, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    const/high16 v0, 0x428c0000    # 70.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 69
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v1, v11, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 70
    const/high16 v0, 0x42480000    # 50.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    const/high16 v0, 0x42480000    # 50.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 72
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 73
    const-string v0, "DUAL1"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 74
    const-string v0, "DUAL2"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 75
    const-string v0, "SINGLE"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 77
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 78
    aget-object v0, v6, v9

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0052

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 80
    const/4 v0, 0x1

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v6, v0

    .line 81
    const/4 v0, 0x1

    aget-object v0, v6, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0051

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 84
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    if-nez v0, :cond_4

    .line 85
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v1, v13, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v3, v11, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 86
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v13

    aget-object v1, v6, v9

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v10

    add-float/2addr v1, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v12

    aget-object v2, v6, v9

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v10

    add-float/2addr v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v11

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v10

    sub-float v3, v0, v3

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v9

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    const/4 v0, 0x1

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 87
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 88
    const-string v0, "DUAL1"

    const/high16 v1, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 104
    :cond_1
    :goto_0
    const/4 v0, 0x2

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v6, v0

    .line 105
    const/4 v0, 0x2

    aget-object v0, v6, v0

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 106
    const/4 v0, 0x2

    aget-object v0, v6, v0

    invoke-virtual {v0, v12}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 107
    const/4 v0, 0x2

    aget-object v0, v6, v0

    sget-object v1, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 109
    const/4 v0, 0x3

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v6, v0

    .line 110
    const/4 v0, 0x3

    aget-object v0, v6, v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c001f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 111
    const/4 v0, 0x3

    aget-object v0, v6, v0

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 115
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f030034

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v7

    .line 116
    .local v7, "throttle":Landroid/graphics/Bitmap;
    const/high16 v0, 0x40400000    # 3.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    const/high16 v1, 0x40400000    # 3.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v2

    float-to-int v1, v1

    const/4 v2, 0x1

    invoke-static {v7, v0, v1, v2}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 118
    .local v8, "throttle_icon":Landroid/graphics/Bitmap;
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_7

    .line 119
    :cond_2
    const/high16 v0, 0x41a00000    # 20.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41a00000    # 20.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42700000    # 60.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42200000    # 40.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x2

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 120
    const/high16 v0, 0x41b80000    # 23.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42140000    # 37.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42140000    # 37.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x3

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 121
    const/high16 v0, 0x422c0000    # 43.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41b80000    # 23.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42640000    # 57.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42140000    # 37.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x3

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 122
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    if-nez v0, :cond_6

    .line 123
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v11

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v11

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {p1, v8, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 124
    const/high16 v0, 0x42480000    # 50.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v1

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v11

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {p1, v8, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 137
    :cond_3
    :goto_1
    return-void

    .line 90
    .end local v7    # "throttle":Landroid/graphics/Bitmap;
    .end local v8    # "throttle_icon":Landroid/graphics/Bitmap;
    :cond_4
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_5

    .line 91
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v1, v11, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    const/high16 v0, 0x42480000    # 50.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 92
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v11

    aget-object v1, v6, v9

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v10

    add-float/2addr v1, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v12

    aget-object v2, v6, v9

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v10

    add-float/2addr v2, v0

    const/high16 v0, 0x42480000    # 50.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v10

    sub-float v3, v0, v3

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v9

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    const/4 v0, 0x1

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 93
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 94
    const-string v0, "DUAL2"

    const/high16 v1, 0x42200000    # 40.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 97
    :cond_5
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 98
    const/high16 v0, 0x42480000    # 50.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float v2, v12, v0

    const/high16 v0, 0x428c0000    # 70.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    aget-object v5, v6, v9

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 99
    const/high16 v0, 0x42480000    # 50.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v1

    aget-object v1, v6, v9

    invoke-virtual {v1}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v1

    div-float/2addr v1, v10

    add-float/2addr v1, v0

    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v12

    aget-object v2, v6, v9

    invoke-virtual {v2}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v2

    div-float/2addr v2, v10

    add-float/2addr v2, v0

    const/high16 v0, 0x428c0000    # 70.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v3

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v3

    div-float/2addr v3, v10

    sub-float v3, v0, v3

    const/high16 v0, 0x41700000    # 15.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v0, v4

    aget-object v4, v6, v9

    invoke-virtual {v4}, Landroid/graphics/Paint;->getStrokeWidth()F

    move-result v4

    sub-float v4, v0, v4

    const/4 v0, 0x1

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 100
    aget-object v0, v6, v9

    sget-object v1, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 101
    const-string v0, "SINGLE"

    const/high16 v1, 0x42700000    # 60.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v2

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v13

    aget-object v3, v6, v9

    invoke-virtual {v3}, Landroid/graphics/Paint;->getTextSize()F

    move-result v3

    div-float/2addr v3, v10

    add-float/2addr v2, v3

    aget-object v3, v6, v9

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 126
    .restart local v7    # "throttle":Landroid/graphics/Bitmap;
    .restart local v8    # "throttle_icon":Landroid/graphics/Bitmap;
    :cond_6
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_3

    .line 127
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v11

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v11

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {p1, v8, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 128
    aget-object v0, v6, v9

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v10

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 129
    aget-object v0, v6, v9

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0028

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    goto/16 :goto_1

    .line 132
    :cond_7
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getMYJOYSTICK()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    .line 133
    iget v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float v1, v11, v0

    const/high16 v0, 0x41880000    # 17.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42480000    # 50.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x422c0000    # 43.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x2

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 134
    const/high16 v0, 0x42000000    # 32.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v1, v0

    const/high16 v0, 0x41c80000    # 25.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v0

    const/high16 v0, 0x42400000    # 48.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v3, v0

    const/high16 v0, 0x42240000    # 41.0f

    iget v4, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v4, v0

    const/4 v0, 0x3

    aget-object v5, v6, v0

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 135
    const/high16 v0, 0x42200000    # 40.0f

    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v0, v1

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    sub-float/2addr v0, v1

    const/high16 v1, 0x42040000    # 33.0f

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v1, v2

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    sub-float/2addr v1, v2

    const/4 v2, 0x0

    invoke-virtual {p1, v8, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    goto/16 :goto_1
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 9
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/high16 v8, 0x42480000    # 50.0f

    const/high16 v7, 0x41f00000    # 30.0f

    const/high16 v6, 0x41700000    # 15.0f

    const/high16 v5, 0x40a00000    # 5.0f

    const/4 v4, 0x0

    .line 141
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_2

    .line 142
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 143
    .local v0, "joystickIntent":Landroid/content/Intent;
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x41200000    # 10.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v3

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v7

    cmpg-float v1, v1, v2

    if-gez v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_0

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_0

    .line 144
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/MultiData;->setMYJOYSTICK(I)V

    .line 145
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 146
    const-string v1, "request dual1"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 147
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->invalidate()V

    .line 148
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 149
    const-string v1, "Setting1View"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "send BroadCast : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v7

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v8

    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_1

    .line 153
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mspdata:Lcom/drms/drms_drone/MultiData;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setMYJOYSTICK(I)V

    .line 154
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 155
    const-string v1, "request dual2"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 156
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->invalidate()V

    .line 157
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 158
    const-string v1, "Setting1View"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "send BroadCast : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v8

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    const/high16 v2, 0x428c0000    # 70.0f

    iget v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->x:F

    mul-float/2addr v2, v3

    cmpg-float v1, v1, v2

    if-gez v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v5

    cmpl-float v1, v1, v2

    if-ltz v1, :cond_2

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v1

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->y:F

    mul-float/2addr v2, v6

    cmpg-float v1, v1, v2

    if-gtz v1, :cond_2

    .line 164
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 165
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->activity:Landroid/app/Activity;

    const-string v2, "\uc900\ube44 \uc911 \uc785\ub2c8\ub2e4."

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 166
    invoke-virtual {p0}, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;->invalidate()V

    .line 171
    .end local v0    # "joystickIntent":Landroid/content/Intent;
    :cond_2
    const/4 v1, 0x1

    return v1
.end method
