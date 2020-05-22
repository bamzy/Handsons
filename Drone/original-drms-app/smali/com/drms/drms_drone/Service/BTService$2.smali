.class Lcom/drms/drms_drone/Service/BTService$2;
.super Landroid/os/Handler;
.source "BTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Service/BTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Service/BTService;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v7, 0x1

    .line 179
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 180
    iget v3, p1, Landroid/os/Message;->what:I

    sparse-switch v3, :sswitch_data_0

    .line 232
    :goto_0
    return-void

    .line 182
    :sswitch_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 183
    .local v0, "action":Landroid/content/Intent;
    iget v3, p1, Landroid/os/Message;->arg1:I

    packed-switch v3, :pswitch_data_0

    .line 222
    :cond_0
    :goto_1
    :pswitch_0
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v3, v0}, Lcom/drms/drms_drone/Service/BTService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    .line 185
    :pswitch_1
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v4, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    iget-object v5, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v5}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v5

    iget-object v6, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v6}, Lcom/drms/drms_drone/Service/BTService;->access$300(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;)V

    invoke-static {v3, v4}, Lcom/drms/drms_drone/Service/BTService;->access$102(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Protocol/Multiwii/MSP;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    .line 186
    const-string v3, "BTService"

    const-string v4, "Connected in Service"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    const-string v3, "connected bluetooth in Service"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 188
    const-string v3, "service"

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 189
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v3

    if-nez v3, :cond_1

    .line 190
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$500(Lcom/drms/drms_drone/Service/BTService;)V

    goto :goto_1

    .line 191
    :cond_1
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v3

    if-ne v3, v7, :cond_0

    .line 192
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$600(Lcom/drms/drms_drone/Service/BTService;)V

    goto :goto_1

    .line 197
    :pswitch_2
    const-string v3, "BTService"

    const-string v4, "Connection Failed"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 198
    const-string v3, "failed bluetooth in Service"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 199
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->stop()V

    .line 200
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v4, Landroid/content/Intent;

    const-string v5, "discovr failed"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/Service/BTService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_1

    .line 205
    :pswitch_3
    const-string v3, "BTService"

    const-string v4, "disconnected"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 206
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 207
    .local v1, "btdisconnectedIntent":Landroid/content/Intent;
    const-string v3, "disconnected bluetooth in Service"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 208
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-virtual {v3, v0}, Lcom/drms/drms_drone/Service/BTService;->sendBroadcast(Landroid/content/Intent;)V

    .line 209
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$700(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    aget-object v3, v3, v7

    const-string v4, ""

    if-eq v3, v4, :cond_0

    .line 210
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v4, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;

    iget-object v5, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {v4, v5}, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-static {v3, v4}, Lcom/drms/drms_drone/Service/BTService;->access$802(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 211
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3, v7}, Lcom/drms/drms_drone/Service/BTService;->access$902(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 212
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$800(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/Thread;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    goto/16 :goto_1

    .line 217
    .end local v1    # "btdisconnectedIntent":Landroid/content/Intent;
    :pswitch_4
    const-string v3, "BTService"

    const-string v4, "state_none"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 218
    const-string v3, "disconnected bluetooth in Service"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 226
    .end local v0    # "action":Landroid/content/Intent;
    :sswitch_1
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [B

    move-object v2, v3

    check-cast v2, [B

    .line 227
    .local v2, "data":[B
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$2;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->readMSP([B)V

    goto/16 :goto_0

    .line 180
    nop

    :sswitch_data_0
    .sparse-switch
        0xa -> :sswitch_0
        0x66 -> :sswitch_1
    .end sparse-switch

    .line 183
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
