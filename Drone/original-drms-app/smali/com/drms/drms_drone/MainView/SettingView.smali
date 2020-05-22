.class public Lcom/drms/drms_drone/MainView/SettingView;
.super Landroid/widget/LinearLayout;
.source "SettingView.java"


# instance fields
.field private TAG:Ljava/lang/String;

.field canvas_height:F

.field canvas_width:F

.field private mActivity:Landroid/app/Activity;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mContext:Landroid/content/Context;

.field private mPaint:[Landroid/graphics/Paint;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x0

    .line 41
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 27
    iput v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_width:F

    .line 28
    iput v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_height:F

    .line 30
    const-class v0, Lcom/drms/drms_drone/MainView/SettingView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->TAG:Ljava/lang/String;

    .line 36
    const/4 v0, 0x5

    new-array v0, v0, [Landroid/graphics/Paint;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    .line 43
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mContext:Landroid/content/Context;

    .line 44
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/SettingView;->mActivity:Landroid/app/Activity;

    .line 46
    new-instance v0, Lcom/drms/drms_drone/Sound/SoundManager;

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/drms/drms_drone/Sound/SoundManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    .line 48
    return-void
.end method


# virtual methods
.method public drawTopic(Landroid/graphics/Canvas;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/high16 v5, 0x40000000    # 2.0f

    const/4 v4, 0x0

    .line 65
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    aput-object v1, v0, v4

    .line 66
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    sget-object v1, Landroid/graphics/Paint$Align;->LEFT:Landroid/graphics/Paint$Align;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextAlign(Landroid/graphics/Paint$Align;)V

    .line 67
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x428c0000    # 70.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 68
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    const/high16 v1, 0x40a00000    # 5.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 69
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v0, v0, v4

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c002b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 71
    const-string v0, " \uc124 \uc815 "

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v1, v1, v4

    invoke-virtual {v1}, Landroid/graphics/Paint;->getTextSize()F

    move-result v1

    div-float/2addr v1, v5

    iget-object v2, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v2, v2, v4

    invoke-virtual {v2}, Landroid/graphics/Paint;->getTextSize()F

    move-result v2

    const/high16 v3, 0x40400000    # 3.0f

    mul-float/2addr v2, v3

    div-float/2addr v2, v5

    iget-object v3, p0, Lcom/drms/drms_drone/MainView/SettingView;->mPaint:[Landroid/graphics/Paint;

    aget-object v3, v3, v4

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 72
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 52
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->onDraw(Landroid/graphics/Canvas;)V

    .line 55
    iget v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_width:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    iget v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_height:F

    cmpl-float v0, v0, v1

    if-nez v0, :cond_0

    .line 56
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getWidth()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_width:F

    .line 57
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getHeight()I

    move-result v0

    int-to-float v0, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_height:F

    .line 58
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Canvas Width : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_width:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\nCanvas Height : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/MainView/SettingView;->canvas_height:F

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    :cond_0
    invoke-virtual {p0, p1}, Lcom/drms/drms_drone/MainView/SettingView;->drawTopic(Landroid/graphics/Canvas;)V

    .line 62
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 7
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 76
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 101
    :cond_0
    :goto_0
    return v5

    .line 79
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-ne v1, v5, :cond_0

    .line 80
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v1

    if-ne v1, v6, :cond_2

    .line 82
    const-wide/16 v2, 0x1e

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    :goto_1
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mContext:Landroid/content/Context;

    const-class v2, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 88
    .local v0, "settingIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mActivity:Landroid/app/Activity;

    invoke-virtual {v1, v0, v6}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 89
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mActivity:Landroid/app/Activity;

    const v2, 0x7f05000b

    const v3, 0x7f05000c

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 90
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    goto :goto_0

    .line 93
    .end local v0    # "settingIntent":Landroid/content/Intent;
    :cond_2
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v1

    const/4 v2, 0x3

    if-ne v1, v2, :cond_3

    .line 94
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mActivity:Landroid/app/Activity;

    const-string v2, "\ub4dc\ub860 \uc5f0\uacb0 \uc911"

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 97
    :cond_3
    iget-object v1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mActivity:Landroid/app/Activity;

    const-string v2, "\ub4dc\ub860\uc744 \uc5f0\uacb0\ud574\uc8fc\uc138\uc694."

    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 83
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public setmBTService(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 2
    .param p1, "mBTService"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/SettingView;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    .line 106
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/SettingView;->TAG:Ljava/lang/String;

    const-string v1, "set BTService in SettingView"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    return-void
.end method
