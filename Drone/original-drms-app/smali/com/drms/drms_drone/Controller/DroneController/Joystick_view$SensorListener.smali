.class public Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$SensorListener;
.super Ljava/lang/Object;
.source "Joystick_view.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SensorListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;


# direct methods
.method protected constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    .prologue
    .line 575
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0
    .param p1, "sensor"    # Landroid/hardware/Sensor;
    .param p2, "i"    # I

    .prologue
    .line 584
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 0
    .param p1, "sensorEvent"    # Landroid/hardware/SensorEvent;

    .prologue
    .line 579
    return-void
.end method
