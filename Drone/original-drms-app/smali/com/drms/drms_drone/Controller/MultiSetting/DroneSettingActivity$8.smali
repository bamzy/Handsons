.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;
.super Landroid/os/Handler;
.source "DroneSettingActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 469
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 2
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 472
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 473
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 482
    :cond_0
    :goto_0
    return-void

    .line 475
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5308(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)I

    move-result v0

    invoke-static {}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5400()I

    move-result v1

    if-lt v0, v1, :cond_0

    .line 476
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;->invalidate()V

    .line 477
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$8;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5302(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;I)I

    goto :goto_0

    .line 473
    nop

    :pswitch_data_0
    .packed-switch 0x64
        :pswitch_0
    .end packed-switch
.end method
