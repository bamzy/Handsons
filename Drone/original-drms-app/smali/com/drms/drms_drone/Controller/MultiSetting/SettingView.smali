.class public Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;
.super Landroid/view/View;
.source "SettingView.java"


# instance fields
.field protected canvasHeight:F

.field protected canvasWidth:F

.field protected mActivity:Landroid/app/Activity;

.field protected mContext:Landroid/content/Context;

.field protected mspdata:Lcom/drms/drms_drone/MultiData;

.field protected x:F

.field protected y:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/Activity;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mActivity"    # Landroid/app/Activity;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 25
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;->mContext:Landroid/content/Context;

    .line 26
    iput-object p2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;->mActivity:Landroid/app/Activity;

    .line 28
    invoke-virtual {p2}, Landroid/app/Activity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/SettingView;->mspdata:Lcom/drms/drms_drone/MultiData;

    .line 29
    return-void
.end method
