.class Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;
.super Landroid/content/BroadcastReceiver;
.source "JoystickActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    .prologue
    .line 228
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v5, 0x0

    .line 231
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 233
    .local v0, "action":Ljava/lang/String;
    const-string v2, "android.intent.action.BATTERY_CHANGED"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 234
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    const-string v3, "level"

    invoke-virtual {p2, v3, v5}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v3

    iput v3, v2, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->battery_level:I

    .line 235
    const-string v2, "JoystickActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "vbat : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    iget v4, v4, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->battery_level:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 236
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->getApplication()Landroid/app/Application;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/MultiData;

    .line 237
    .local v1, "msp":Lcom/drms/drms_drone/MultiData;
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    iget v2, v2, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->battery_level:I

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/MultiData;->setMobile_vbat(I)V

    .line 240
    .end local v1    # "msp":Lcom/drms/drms_drone/MultiData;
    :cond_0
    const-string v2, "disconnected bluetooth in Service"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 241
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-virtual {v2, v5}, Lcom/drms/drms_drone/Service/BTService;->setCurrentDisplay(I)V

    .line 242
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->setResult(I)V

    .line 243
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->finish()V

    .line 246
    :cond_1
    const-string v2, "request dual1"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "request dual2"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 247
    :cond_2
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 248
    const-string v2, "JoystickActivity"

    const-string v3, "unregister Listener"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 249
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 251
    :cond_3
    const-string v2, "JoystickActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "received Message : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 252
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$700(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Ljava/lang/String;)V

    .line 255
    :cond_4
    const-string v2, "request single"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 256
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v2

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v2

    if-eqz v2, :cond_5

    .line 257
    const-string v2, "JoystickActivity"

    const-string v3, "unregister Listener"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 258
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorManager()Landroid/hardware/SensorManager;

    move-result-object v2

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->getmSensorEventListener()Landroid/hardware/SensorEventListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/hardware/SensorManager;->unregisterListener(Landroid/hardware/SensorEventListener;)V

    .line 260
    :cond_5
    const-string v2, "JoystickActivity"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "received Message : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 261
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2, v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$700(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Ljava/lang/String;)V

    .line 263
    :cond_6
    const-string v2, "arduino reset"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 264
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->finish()V

    .line 266
    :cond_7
    const-string v2, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 269
    :cond_8
    const-string v2, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 270
    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$3;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->finish()V

    .line 272
    :cond_9
    return-void
.end method
