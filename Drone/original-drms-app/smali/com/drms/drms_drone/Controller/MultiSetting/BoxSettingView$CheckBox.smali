.class Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;
.super Ljava/lang/Object;
.source "BoxSettingView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CheckBox"
.end annotation


# instance fields
.field private checked:Z

.field private displayed_check:Landroid/graphics/Bitmap;

.field private off:Landroid/graphics/Bitmap;

.field private on:Landroid/graphics/Bitmap;

.field private positionX:F

.field private positionY:F

.field final synthetic this$0:Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;FFZ)V
    .locals 1
    .param p2, "x"    # F
    .param p3, "y"    # F
    .param p4, "checked"    # Z

    .prologue
    .line 162
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 163
    iput p2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->positionX:F

    .line 164
    iput p3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->positionY:F

    .line 165
    iput-boolean p4, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->checked:Z

    .line 167
    invoke-static {p1}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->access$000(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->on:Landroid/graphics/Bitmap;

    .line 168
    invoke-static {p1}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;->access$100(Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->off:Landroid/graphics/Bitmap;

    .line 169
    if-eqz p4, :cond_0

    .line 170
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->off:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->displayed_check:Landroid/graphics/Bitmap;

    .line 173
    :goto_0
    return-void

    .line 172
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->on:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->displayed_check:Landroid/graphics/Bitmap;

    goto :goto_0
.end method


# virtual methods
.method public getDisplayed_check()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->displayed_check:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getPositionX()F
    .locals 1

    .prologue
    .line 180
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->positionX:F

    return v0
.end method

.method public getPositionY()F
    .locals 1

    .prologue
    .line 184
    iget v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->positionY:F

    return v0
.end method

.method public isChecked()Z
    .locals 1

    .prologue
    .line 188
    iget-boolean v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->checked:Z

    return v0
.end method

.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 192
    iput-boolean p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->checked:Z

    .line 193
    if-eqz p1, :cond_0

    .line 194
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->off:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->displayed_check:Landroid/graphics/Bitmap;

    .line 199
    :goto_0
    return-void

    .line 197
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->on:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView$CheckBox;->displayed_check:Landroid/graphics/Bitmap;

    goto :goto_0
.end method
