.class public Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;
.super Landroid/view/View;
.source "UploadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Upload/UploadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ProgressView"
.end annotation


# instance fields
.field private droneLocation:F

.field private executedPaint:Landroid/graphics/Paint;

.field private non_execuetPaint:Landroid/graphics/Paint;

.field private progress:I

.field private progressDrone:Landroid/graphics/Bitmap;

.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadManager;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager;Landroid/content/Context;)V
    .locals 4
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/high16 v2, 0x41f00000    # 30.0f

    const/4 v3, 0x0

    .line 489
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    .line 490
    invoke-direct {p0, p2}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 487
    iput v3, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    .line 492
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->non_execuetPaint:Landroid/graphics/Paint;

    .line 493
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->non_execuetPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 494
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->non_execuetPaint:Landroid/graphics/Paint;

    const v1, -0x777778

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 496
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->executedPaint:Landroid/graphics/Paint;

    .line 497
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->executedPaint:Landroid/graphics/Paint;

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 498
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->executedPaint:Landroid/graphics/Paint;

    invoke-static {p1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0048

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 500
    invoke-static {p1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f020059

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    .line 501
    iput v3, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    .line 502
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 506
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 508
    const-string v0, "UplaodManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "progress : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progress:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 510
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    mul-int/lit8 v1, v1, 0x2

    sub-int/2addr v0, v1

    int-to-float v6, v0

    .line 511
    .local v6, "progressLength":F
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    iget v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progress:I

    int-to-float v1, v1

    mul-float/2addr v1, v6

    const/high16 v2, 0x42c80000    # 100.0f

    div-float/2addr v1, v2

    add-float/2addr v0, v1

    iput v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    .line 514
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    int-to-float v1, v0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v2, v0

    iget v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    add-float/2addr v3, v0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->executedPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 515
    iget v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    add-float/2addr v1, v0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v2, v0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    sub-int/2addr v0, v3

    int-to-float v3, v0

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v4, v0

    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->non_execuetPaint:Landroid/graphics/Paint;

    move-object v0, p1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 519
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    iget v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->droneLocation:F

    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progressDrone:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    div-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    int-to-float v2, v2

    const/4 v3, 0x0

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 521
    return-void
.end method

.method public setProgress(I)V
    .locals 0
    .param p1, "progress"    # I

    .prologue
    .line 524
    iput p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->progress:I

    .line 525
    return-void
.end method
