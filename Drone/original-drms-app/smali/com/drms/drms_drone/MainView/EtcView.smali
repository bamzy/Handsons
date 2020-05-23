.class public Lcom/drms/drms_drone/MainView/EtcView;
.super Landroid/widget/LinearLayout;
.source "EtcView.java"


# instance fields
.field private TAG:Ljava/lang/String;

.field canvas_height:F

.field canvas_width:F

.field private mActivity:Landroid/app/Activity;

.field private mContext:Landroid/content/Context;

.field private mPaint:[Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 21
    iput v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_width:F

    .line 22
    iput v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_height:F

    .line 24
    const-class v0, Lcom/drms/drms_drone/MainView/EtcView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->TAG:Ljava/lang/String;

    .line 30
    const/4 v0, 0x5

    new-array v0, v0, [Landroid/graphics/Paint;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    .line 33
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/EtcView;->mContext:Landroid/content/Context;

    .line 34
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/EtcView;->mActivity:Landroid/app/Activity;

    .line 37
    return-void
.end method


# virtual methods
.method public drawTopic(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v5, 0x40000000    # 2.0f

    const/4 v4, 0x0

    .line 54
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v0, v4

    .line 55
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 56
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x428c0000    # 70.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 57
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 58
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/EtcView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 60
    const-string v0, "اطلاعات"

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v4

    invoke-virtual {v1}, Landroid/graphics/Paint;->getTextSize()F

    move-result v1

    div-float/2addr v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v2, v2, v4

    invoke-virtual {v2}, Landroid/graphics/Paint;->getTextSize()F

    move-result v2

    const/high16 v3, 0x40400000    # 3.0f

    mul-float/2addr v2, v3

    div-float/2addr v2, v5

    iget-object v3, p0, Lcom/drms/drms_drone/MainView/EtcView;->mPaint:[Landroid/graphics/Paint;

    aget-object v3, v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 61
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 41
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 44
    iget v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_width:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_height:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 45
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_width:F

    .line 46
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_height:F

    .line 47
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/EtcView;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Canvas Width : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_width:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\nCanvas Height : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/EtcView;->canvas_height:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    :cond_0
    invoke-virtual {p0, p1}, Lcom/drms/drms_drone/MainView/EtcView;->drawTopic(Landroid/graphics/Canvas;)V

    .line 51
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v3, 0x1

    .line 65
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    .line 71
    :cond_0
    :goto_0
    return v3

    .line 68
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 69
    new-instance v0, Lcom/drms/drms_drone/Download/DownloadManager;

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/EtcView;->mActivity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/EtcView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1, v2}, Lcom/drms/drms_drone/Download/DownloadManager;-><init>(Landroid/app/Activity;Landroid/content/Context;)V

    invoke-virtual {v0}, Lcom/drms/drms_drone/Download/DownloadManager;->download()V

    goto :goto_0
.end method
