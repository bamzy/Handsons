.class Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;
.super Ljava/lang/Object;
.source "Dual2JoystickView.java"

# interfaces
.implements Landroid/hardware/SensorEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SensorListener"
.end annotation


# instance fields
.field pitch:F

.field roll:F

.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

.field yaw:F


# direct methods
.method private constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;
    .param p2, "x1"    # Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$1;

    .prologue
    .line 75
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;-><init>(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)V

    return-void
.end method


# virtual methods
.method public onAccuracyChanged(Landroid/hardware/Sensor;I)V
    .locals 0
    .param p1, "sensor"    # Landroid/hardware/Sensor;
    .param p2, "i"    # I

    .prologue
    .line 119
    return-void
.end method

.method public onSensorChanged(Landroid/hardware/SensorEvent;)V
    .locals 8
    .param p1, "sensorEvent"    # Landroid/hardware/SensorEvent;

    .prologue
    const v7, 0x44bb8000    # 1500.0f

    const/4 v6, 0x0

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 83
    iget-object v0, p1, Landroid/hardware/SensorEvent;->values:[F

    .line 84
    .local v0, "v":[F
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget v2, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->sensorCount:I

    add-int/lit8 v3, v2, 0x1

    iput v3, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->sensorCount:I

    if-gt v2, v5, :cond_5

    .line 85
    iget-object v1, p1, Landroid/hardware/SensorEvent;->sensor:Landroid/hardware/Sensor;

    invoke-virtual {v1}, Landroid/hardware/Sensor;->getType()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 114
    :goto_0
    return-void

    .line 87
    :pswitch_0
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->access$100(Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 89
    aget v1, v0, v4

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->yaw:F

    .line 90
    aget v1, v0, v5

    neg-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    .line 91
    const/4 v1, 0x2

    aget v1, v0, v1

    neg-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    .line 93
    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v2

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v1

    int-to-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    .line 94
    :cond_0
    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v2

    neg-int v2, v2

    int-to-float v2, v2

    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v1

    neg-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    .line 95
    :cond_1
    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v2

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_2

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v1

    int-to-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    .line 96
    :cond_2
    iget v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v2

    neg-int v2, v2

    int-to-float v2, v2

    cmpg-float v1, v1, v2

    if-gez v1, :cond_3

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v1}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v1

    neg-int v1, v1

    int-to-float v1, v1

    iput v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    .line 103
    :cond_3
    :goto_1
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v2, v3

    add-float/2addr v2, v7

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v3

    aget v3, v3, v4

    int-to-float v3, v3

    add-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->rollToMSP:I

    .line 104
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getDRONE_SPEED()I

    move-result v3

    int-to-float v3, v3

    mul-float/2addr v2, v3

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getSmartphoneAngle()I

    move-result v3

    int-to-float v3, v3

    div-float/2addr v2, v3

    add-float/2addr v2, v7

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    invoke-virtual {v3}, Lcom/drms/drms_drone/MultiData;->getTream()[I

    move-result-object v3

    aget v3, v3, v5

    int-to-float v3, v3

    add-float/2addr v2, v3

    float-to-int v2, v2

    iput v2, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->pitchToMSP:I

    .line 105
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->mspdata:Lcom/drms/drms_drone/MultiData;

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget v2, v2, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->rollToMSP:I

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iget v3, v3, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->pitchToMSP:I

    invoke-virtual {v1, v2, v3}, Lcom/drms/drms_drone/MultiData;->setRawRCDataRollPitch(II)V

    goto/16 :goto_0

    .line 99
    :cond_4
    iput v6, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->roll:F

    .line 100
    iput v6, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->pitch:F

    goto :goto_1

    .line 112
    :cond_5
    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView$SensorListener;->this$0:Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;

    iput v4, v1, Lcom/drms/drms_drone/Controller/DroneController/Dual2JoystickView;->sensorCount:I

    goto/16 :goto_0

    .line 85
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method
