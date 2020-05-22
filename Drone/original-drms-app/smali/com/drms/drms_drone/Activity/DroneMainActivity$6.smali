.class Lcom/drms/drms_drone/Activity/DroneMainActivity$6;
.super Landroid/os/Handler;
.source "DroneMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 443
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 4
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v3, 0x1

    .line 446
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 447
    iget v1, p1, Landroid/os/Message;->what:I

    sparse-switch v1, :sswitch_data_0

    .line 473
    :goto_0
    return-void

    .line 449
    :sswitch_0
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/Playflight;

    move-result-object v1

    invoke-virtual {v1}, Lcom/drms/drms_drone/MainView/Playflight;->invalidate()V

    goto :goto_0

    .line 454
    :sswitch_1
    iget v1, p1, Landroid/os/Message;->arg1:I

    packed-switch v1, :pswitch_data_0

    goto :goto_0

    .line 456
    :pswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 457
    .local v0, "data":Ljava/lang/String;
    const-string v1, "USBActivity"

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 462
    .end local v0    # "data":Ljava/lang/String;
    :pswitch_1
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v2, "CTS_CHANGE"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 465
    :pswitch_2
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$6;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v2, "DSR_CHANGE"

    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 447
    :sswitch_data_0
    .sparse-switch
        0xb -> :sswitch_1
        0x64 -> :sswitch_0
    .end sparse-switch

    .line 454
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
