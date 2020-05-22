.class Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;
.super Ljava/lang/Object;
.source "Playflight.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/MainView/Playflight;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CurrentDrone"
.end annotation


# instance fields
.field private current_vbat:F

.field private drone:Landroid/graphics/Bitmap;

.field private pitch:F

.field private roll:F

.field final synthetic this$0:Lcom/drms/drms_drone/MainView/Playflight;

.field private x:F

.field private y:F

.field private yaw:F


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/MainView/Playflight;Landroid/graphics/Bitmap;FF)V
    .locals 0
    .param p2, "drone"    # Landroid/graphics/Bitmap;
    .param p3, "x"    # F
    .param p4, "y"    # F

    .prologue
    .line 357
    iput-object p1, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->this$0:Lcom/drms/drms_drone/MainView/Playflight;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 358
    iput-object p2, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->drone:Landroid/graphics/Bitmap;

    .line 359
    iput p3, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->x:F

    .line 360
    iput p4, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->y:F

    .line 361
    return-void
.end method


# virtual methods
.method public getDrone()Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 364
    iget-object v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->drone:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method public getX()F
    .locals 1

    .prologue
    .line 368
    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->x:F

    return v0
.end method

.method public getY()F
    .locals 1

    .prologue
    .line 372
    iget v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->y:F

    return v0
.end method

.method public setRPY([F)V
    .locals 1
    .param p1, "rpy"    # [F

    .prologue
    .line 376
    const/4 v0, 0x0

    aget v0, p1, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->roll:F

    .line 377
    const/4 v0, 0x1

    aget v0, p1, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->pitch:F

    .line 378
    const/4 v0, 0x2

    aget v0, p1, v0

    iput v0, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->yaw:F

    .line 379
    return-void
.end method

.method public setVbat(F)V
    .locals 0
    .param p1, "vbat"    # F

    .prologue
    .line 382
    iput p1, p0, Lcom/drms/drms_drone/MainView/Playflight$CurrentDrone;->current_vbat:F

    .line 383
    return-void
.end method
