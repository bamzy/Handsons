.class Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;
.super Ljava/lang/Object;
.source "JoystickActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


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
    .line 107
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    check-cast p2, Lcom/drms/drms_drone/Service/BTService$BtBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Service/BTService$BtBinder;->getService()Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$002(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 111
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$100(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Service/BTService;->setHandler(Landroid/os/Handler;)V

    .line 112
    const-string v0, "JoystickActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Service : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 113
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->isControllerConnected()Z

    move-result v0

    if-nez v0, :cond_2

    .line 114
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    .line 117
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$400(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 127
    :cond_1
    :goto_0
    return-void

    .line 122
    :cond_2
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$500(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 123
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$500(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/Service/BTService;->getmBluetoothService()Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->setmBluetoothService(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    goto :goto_0
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 131
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$002(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;

    .line 132
    const-string v0, "JoystickActivity"

    const-string v1, "Service Disconnected"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 133
    return-void
.end method
