.class Lcom/drms/drms_drone/Service/BTService$8;
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
    .line 727
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 8
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/16 v7, 0x64

    const/4 v6, 0x0

    .line 730
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 731
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v4}, Lcom/drms/drms_drone/Service/BTService;->access$1900(Lcom/drms/drms_drone/Service/BTService;)J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Lcom/drms/drms_drone/Service/BTService;->access$1802(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 732
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v3, v4, v5}, Lcom/drms/drms_drone/Service/BTService;->access$1902(Lcom/drms/drms_drone/Service/BTService;J)J

    .line 735
    iget v3, p1, Landroid/os/Message;->what:I

    sparse-switch v3, :sswitch_data_0

    .line 833
    :goto_0
    return-void

    .line 737
    :sswitch_0
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [F

    check-cast v3, [F

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setMISCdata([F)V

    goto :goto_0

    .line 741
    :sswitch_1
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [F

    check-cast v3, [F

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setRCTUNEdata([F)V

    goto :goto_0

    .line 745
    :sswitch_2
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [F

    check-cast v3, [F

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setAnalogData([F)V

    goto :goto_0

    .line 750
    :sswitch_3
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [I

    check-cast v3, [I

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setReceivedRcdata([I)V

    goto :goto_0

    .line 754
    :sswitch_4
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [F

    check-cast v3, [F

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setAttitudeData([F)V

    .line 755
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    invoke-virtual {v3}, Landroid/os/Message;->sendToTarget()V

    goto :goto_0

    .line 760
    :sswitch_5
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v3

    invoke-virtual {v3, v6}, Lcom/drms/drms_drone/MultiData;->setACCCalibration(Z)V

    .line 761
    const-string v3, "BTService"

    const-string v4, "received acc cali"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 762
    const-string v0, "\uac00\uc18d\ub3c4 \uc13c\uc11c \uad50\uc815\uc774 \uc644\ub8cc\ub418\uc5c8\uc2b5\ub2c8\ub2e4."

    .line 763
    .local v0, "finishAcc":Ljava/lang/String;
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v3

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-virtual {v3, v0, v4, v5}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    .line 764
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3, v6}, Lcom/drms/drms_drone/Service/BTService;->access$1302(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 765
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_1
    const/4 v3, 0x4

    if-ge v1, v3, :cond_0

    .line 766
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v3

    const/16 v4, 0x3e8

    invoke-virtual {v3, v1, v4}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 765
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 768
    :cond_0
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    new-instance v4, Lcom/drms/drms_drone/Service/BTService$8$1;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Service/BTService$8$1;-><init>(Lcom/drms/drms_drone/Service/BTService$8;)V

    const-wide/16 v6, 0x1f4

    invoke-virtual {v3, v4, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 779
    .end local v0    # "finishAcc":Ljava/lang/String;
    .end local v1    # "i":I
    :sswitch_6
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    new-instance v4, Lcom/drms/drms_drone/Service/BTService$8$2;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Service/BTService$8$2;-><init>(Lcom/drms/drms_drone/Service/BTService$8;)V

    const-wide/16 v6, 0x7530

    invoke-virtual {v3, v4, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 803
    :sswitch_7
    const-string v3, "BTService"

    const-string v4, "set Header"

    invoke-static {v3, v4}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 807
    :sswitch_8
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [I

    check-cast v3, [I

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setIMUdata([I)V

    .line 808
    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [I

    move-object v2, v3

    check-cast v2, [I

    .line 809
    .local v2, "temp":[I
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v3

    invoke-virtual {v3}, Landroid/os/Message;->sendToTarget()V

    goto/16 :goto_0

    .line 814
    .end local v2    # "temp":[I
    :sswitch_9
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [[Z

    check-cast v3, [[Z

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setCheckboxData([[Z)V

    .line 815
    const-string v3, "BTService"

    const-string v4, "received checkbox"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 819
    :sswitch_a
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [I

    check-cast v3, [I

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setPIDdata([I)V

    .line 820
    const-string v3, "BTService"

    const-string v4, "received pid data"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 824
    :sswitch_b
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [Ljava/lang/String;

    check-cast v3, [Ljava/lang/String;

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->initBoxITEM([Ljava/lang/String;)V

    .line 825
    const-string v3, "BTService"

    const-string v4, "set Box Name"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 829
    :sswitch_c
    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v3, [F

    check-cast v3, [F

    invoke-virtual {v4, v3}, Lcom/drms/drms_drone/MultiData;->setALTITUDEdata([F)V

    goto/16 :goto_0

    .line 735
    :sswitch_data_0
    .sparse-switch
        0x66 -> :sswitch_8
        0x69 -> :sswitch_3
        0x6c -> :sswitch_4
        0x6d -> :sswitch_c
        0x6e -> :sswitch_2
        0x6f -> :sswitch_1
        0x70 -> :sswitch_a
        0x71 -> :sswitch_9
        0x72 -> :sswitch_0
        0x74 -> :sswitch_b
        0xcd -> :sswitch_5
        0xce -> :sswitch_6
        0xd3 -> :sswitch_7
    .end sparse-switch
.end method
