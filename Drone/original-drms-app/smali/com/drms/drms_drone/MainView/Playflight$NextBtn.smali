.class Lcom/drms/drms_drone/MainView/Playflight$NextBtn;
.super Ljava/lang/Object;
.source "Playflight.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/MainView/Playflight;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "NextBtn"
.end annotation


# instance fields
.field private clickedicon:Landroid/graphics/Bitmap;

.field private displayed_icon:Landroid/graphics/Bitmap;

.field private icon:Landroid/graphics/Bitmap;

.field final synthetic this$0:Lcom/drms/drms_drone/MainView/Playflight;

.field private x:F

.field private y:F


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/MainView/Playflight;Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;FF)V
    .locals 0
    .param p2, "icon"    # Landroid/graphics/Bitmap;
    .param p3, "clickedicon"    # Landroid/graphics/Bitmap;
    .param p4, "x"    # F
    .param p5, "y"    # F

    .prologue
    .line 311
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->this$0:Lcom/drms/drms_drone/MainView/Playflight;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 312
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->icon:Landroid/graphics/Bitmap;

    .line 313
    iput-object p3, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->clickedicon:Landroid/graphics/Bitmap;

    .line 314
    iput p4, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->x:F

    .line 315
    iput p5, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->y:F

    .line 316
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->displayed_icon:Landroid/graphics/Bitmap;

    .line 317
    return-void
.end method


# virtual methods
.method public getClickedicon()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 324
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->clickedicon:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getDisplayed_icon()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->displayed_icon:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getIcon()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->icon:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getX()F
    .locals 1

    .prologue
    .line 328
    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->x:F

    return v0
.end method

.method public getY()F
    .locals 1

    .prologue
    .line 332
    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->y:F

    return v0
.end method

.method public setDisplayed_icon(Z)V
    .locals 1
    .param p1, "clicked"    # Z

    .prologue
    .line 340
    if-eqz p1, :cond_0

    .line 341
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->clickedicon:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->displayed_icon:Landroid/graphics/Bitmap;

    .line 346
    :goto_0
    return-void

    .line 344
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->icon:Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$NextBtn;->displayed_icon:Landroid/graphics/Bitmap;

    goto :goto_0
.end method
