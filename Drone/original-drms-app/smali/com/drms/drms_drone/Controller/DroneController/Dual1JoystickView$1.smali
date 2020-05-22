.class Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$1;
.super Ljava/lang/Object;
.source "Dual1JoystickView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->onTouchEvent(Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;

    .prologue
    .line 211
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 214
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual1JoystickView;->mContext:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "request acc calibration"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 215
    return-void
.end method
