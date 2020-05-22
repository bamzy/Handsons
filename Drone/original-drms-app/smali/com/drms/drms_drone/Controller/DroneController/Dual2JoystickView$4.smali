.class Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$4;
.super Ljava/lang/Object;
.source "Dual2JoystickView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->onTouchEvent(Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    .prologue
    .line 625
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$4;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 628
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$4;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mContext:Landroid/content/Context;

    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    const-string v2, "request mag calibration"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 630
    return-void
.end method
