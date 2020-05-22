.class public Lcom/drms/drms_drone/MainView/UploadingView;
.super Landroid/widget/LinearLayout;
.source "UploadingView.java"


# instance fields
.field private TAG:Ljava/lang/String;

.field private bt_address:Ljava/lang/String;

.field canvas_height:F

.field canvas_width:F

.field private mActivity:Landroid/app/Activity;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mContext:Landroid/content/Context;

.field private mPaint:[Landroid/graphics/Paint;

.field private mspdata:Lcom/drms/drms_drone/MultiData;

.field private soundManager:Lcom/drms/drms_drone/Sound/SoundManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x0

    .line 50
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 32
    iput v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_width:F

    .line 33
    iput v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_height:F

    .line 35
    const-class v0, Lcom/drms/drms_drone/MainView/UploadingView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->TAG:Ljava/lang/String;

    .line 44
    const/4 v0, 0x5

    new-array v0, v0, [Landroid/graphics/Paint;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    .line 51
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-direct {v0, p1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->soundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 52
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mContext:Landroid/content/Context;

    .line 53
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mActivity:Landroid/app/Activity;

    .line 54
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 55
    return-void
.end method


# virtual methods
.method public drawTopic(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v5, 0x40000000    # 2.0f

    const/4 v4, 0x0

    .line 73
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v0, v4

    .line 74
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 75
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x428c0000    # 70.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 76
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 77
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 79
    const-string v0, " \uc5c5\ub85c\ub4dc "

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v4

    invoke-virtual {v1}, Landroid/graphics/Paint;->getTextSize()F

    move-result v1

    div-float/2addr v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v2, v2, v4

    invoke-virtual {v2}, Landroid/graphics/Paint;->getTextSize()F

    move-result v2

    const/high16 v3, 0x40400000    # 3.0f

    mul-float/2addr v2, v3

    div-float/2addr v2, v5

    iget-object v3, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v3, v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 80
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 59
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 62
    iget v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_width:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_height:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 63
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_width:F

    .line 64
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_height:F

    .line 65
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Canvas Width : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_width:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\nCanvas Height : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->canvas_height:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    :cond_0
    invoke-virtual {p0, p1}, Lcom/drms/drms_drone/MainView/UploadingView;->drawTopic(Landroid/graphics/Canvas;)V

    .line 70
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 85
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-ne v2, v5, :cond_0

    .line 86
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->soundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v2, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 89
    new-instance v0, Lcom/drms/drms_drone/FileManagement/FileManagement;

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    invoke-direct {v0, v2, v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;-><init>(Landroid/content/Context;Landroid/os/Handler;)V

    .line 91
    .local v0, "mFileManager":Lcom/drms/drms_drone/FileManagement/FileManagement;
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_1

    .line 92
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mActivity:Landroid/app/Activity;

    const-class v3, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 93
    .local v1, "uploadIntent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mActivity:Landroid/app/Activity;

    const/4 v3, 0x5

    invoke-virtual {v2, v1, v3}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 94
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mActivity:Landroid/app/Activity;

    const v3, 0x7f05000b

    const v4, 0x7f05000c

    invoke-virtual {v2, v3, v4}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 105
    .end local v0    # "mFileManager":Lcom/drms/drms_drone/FileManagement/FileManagement;
    .end local v1    # "uploadIntent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return v5

    .line 96
    .restart local v0    # "mFileManager":Lcom/drms/drms_drone/FileManagement/FileManagement;
    :cond_1
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_2

    .line 97
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mContext:Landroid/content/Context;

    const-string v3, "\ub4dc\ub860 \uc5f0\uacb0 \uc911..."

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 100
    :cond_2
    iget-object v2, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mContext:Landroid/content/Context;

    const-string v3, "\ub4dc\ub860\uc744 \uc5f0\uacb0\ud574\uc8fc\uc138\uc694."

    invoke-static {v2, v3, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public setmBTService(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 2
    .param p1, "mBTService"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/UploadingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    .line 110
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/UploadingView;->TAG:Ljava/lang/String;

    const-string v1, "set BTService in UploadView"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    return-void
.end method
