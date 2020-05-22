.class Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;
.super Landroid/os/Handler;
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
    .line 136
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 139
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 140
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_0

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 142
    :sswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->isControllerConnected()Z

    move-result v0

    if-nez v0, :cond_2

    .line 143
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 144
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/Joystick_view;->invalidate()V

    .line 145
    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$400(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$400(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/SingleJoystickView;->invalidate()V

    goto :goto_0

    .line 150
    :cond_2
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$500(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 151
    :cond_3
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$500(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/DrsControllerView;->invalidate()V

    goto :goto_0

    .line 156
    :sswitch_1
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/MultiData;->getReceivedRcdata()[I

    move-result-object v0

    const/4 v1, 0x3

    aget v0, v0, v1

    const/16 v1, 0x41a

    if-gt v0, v1, :cond_4

    .line 157
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->access$600(Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;)V

    goto :goto_0

    .line 160
    :cond_4
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity$2;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/JoystickActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "\ub4dc\ub860\uc774 \ube44\ud589 \uc911 \uc785\ub2c8\ub2e4."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 140
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x64 -> :sswitch_0
    .end sparse-switch
.end method
