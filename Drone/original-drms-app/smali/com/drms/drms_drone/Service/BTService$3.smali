.class Lcom/drms/drms_drone/Service/BTService$3;
.super Landroid/content/BroadcastReceiver;
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
    .line 243
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 16
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 246
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v9

    .line 247
    .local v9, "action":Ljava/lang/String;
    const-string v2, "BTService"

    invoke-static {v2, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 248
    const-string v2, "request_connect_bt"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 274
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$700(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    aget-object v2, v2, v3

    const-string v3, ""

    if-eq v2, v3, :cond_0

    .line 275
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const-string v3, "BT"

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1002(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/String;)Ljava/lang/String;

    .line 276
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {v3, v7}, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;-><init>(Lcom/drms/drms_drone/Service/BTService;)V

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$802(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 277
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$902(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 278
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$800(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 459
    :cond_0
    :goto_0
    return-void

    .line 282
    :cond_1
    const-string v2, "request_finish_service"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 283
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 284
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->stop()V

    .line 286
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$700(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 287
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$700(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v3

    invoke-virtual {v3}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v3

    const/4 v7, 0x1

    aget-object v3, v3, v7

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1002(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/String;)Ljava/lang/String;

    .line 289
    :cond_2
    const-string v2, "BTService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "bt_address in Service : "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v7}, Lcom/drms/drms_drone/Service/BTService;->access$1000(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 292
    :cond_3
    const-string v2, "request controller display"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 293
    const-string v2, "BTService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Bluetooth State : + "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v7}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 295
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 297
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$600(Lcom/drms/drms_drone/Service/BTService;)V

    .line 298
    const-string v2, "BTService"

    const-string v3, "Received Request Controller BroadCast "

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 300
    :cond_4
    const-string v2, "request_program"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 301
    const-string v2, "BTService"

    const-string v3, "program Drone Mode"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 302
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x4

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 303
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1100(Lcom/drms/drms_drone/Service/BTService;)V

    goto/16 :goto_0

    .line 306
    :cond_5
    const-string v2, "bluetooth address"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 307
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const-string v3, "BT"

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1002(Lcom/drms/drms_drone/Service/BTService;Ljava/lang/String;)Ljava/lang/String;

    .line 308
    const-string v2, "BTService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "BT address in Service : "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v7}, Lcom/drms/drms_drone/Service/BTService;->access$1000(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 309
    :cond_6
    const-string v2, "request upload display"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 310
    const-string v2, "BTService"

    const-string v3, "preparing upload"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 311
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x2

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 312
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    const-string v3, "STK"

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setProtocol(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 313
    :cond_7
    const-string v2, "request main display"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 314
    const-string v2, "BTService"

    const-string v3, "request main display"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    const-string v3, "MSP"

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setProtocol(Ljava/lang/String;)V

    .line 316
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1200(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$3$1;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/drms/drms_drone/Service/BTService$3$1;-><init>(Lcom/drms/drms_drone/Service/BTService$3;)V

    const-wide/16 v12, 0x3e8

    invoke-virtual {v2, v3, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 324
    :cond_8
    const-string v2, "request acc calibration"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 325
    const-string v2, "BTService"

    const-string v3, "request acc Calibration"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 326
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1302(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 328
    const-wide/16 v2, 0x12c

    :try_start_0
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 332
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v3

    const/16 v7, 0xcd

    invoke-virtual {v3, v7}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 333
    const-string v8, "\uac00\uc18d\ub3c4 \uc13c\uc11c \uad50\uc815\uc744 \uc2dc\uc791\ud569\ub2c8\ub2e4."

    .line 334
    .local v8, "accCali":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v7, 0x0

    invoke-virtual {v2, v8, v3, v7}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 335
    .end local v8    # "accCali":Ljava/lang/String;
    :cond_9
    const-string v2, "request mag calibration"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 336
    const-string v2, "BTService"

    const-string v3, "request mag Calibration"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 337
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$1302(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 339
    const-wide/16 v2, 0x12c

    :try_start_1
    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    .line 343
    :goto_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$100(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Protocol/Multiwii/MSP;

    move-result-object v3

    const/16 v7, 0xce

    invoke-virtual {v3, v7}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->requestMSP(I)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Protocol/Multiwii/MSP;->sendRequestMSP(Ljava/util/List;)V

    .line 344
    const-string v11, "\uc9c0\uc790\uacc4 \uc13c\uc11c \uad50\uc815\uc744 \uc2dc\uc791\ud569\ub2c8\ub2e4."

    .line 345
    .local v11, "magCali":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v7, 0x0

    invoke-virtual {v2, v11, v3, v7}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 346
    .end local v11    # "magCali":Ljava/lang/String;
    :cond_a
    const-string v2, "reqeust set head"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 347
    const-string v2, "head"

    const/4 v3, 0x0

    move-object/from16 v0, p2

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v10

    .line 348
    .local v10, "heading":I
    const-string v2, "BTService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "heading : "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 350
    .end local v10    # "heading":I
    :cond_b
    const-string v2, "request display setting"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 351
    const-string v2, "BTService"

    invoke-static {v2, v9}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 352
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    const-string v3, "MSP"

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setProtocol(Ljava/lang/String;)V

    .line 353
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1200(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$3$2;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/drms/drms_drone/Service/BTService$3$2;-><init>(Lcom/drms/drms_drone/Service/BTService$3;)V

    const-wide/16 v12, 0x3e8

    invoke-virtual {v2, v3, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 361
    :cond_c
    const-string v2, "request box setting"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 362
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, -0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 363
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$3$3;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/Service/BTService$3$3;-><init>(Lcom/drms/drms_drone/Service/BTService$3;Landroid/content/Intent;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v2, v3, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 382
    :cond_d
    const-string v2, "request rc setting"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    .line 383
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, -0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 385
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$3$4;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v3, v0, v1}, Lcom/drms/drms_drone/Service/BTService$3$4;-><init>(Lcom/drms/drms_drone/Service/BTService$3;Landroid/content/Intent;)V

    const-wide/16 v12, 0x1f4

    invoke-virtual {v2, v3, v12, v13}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 409
    :cond_e
    const-string v2, "request pid setting"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 410
    const-string v2, "P"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getFloatArrayExtra(Ljava/lang/String;)[F

    move-result-object v4

    .line 411
    .local v4, "p":[F
    const-string v2, "I"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getFloatArrayExtra(Ljava/lang/String;)[F

    move-result-object v5

    .line 412
    .local v5, "i":[F
    const-string v2, "D"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getFloatArrayExtra(Ljava/lang/String;)[F

    move-result-object v6

    .line 413
    .local v6, "d":[F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, -0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$402(Lcom/drms/drms_drone/Service/BTService;I)I

    .line 414
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v12

    new-instance v2, Lcom/drms/drms_drone/Service/BTService$3$5;

    move-object/from16 v3, p0

    move-object/from16 v7, p2

    invoke-direct/range {v2 .. v7}, Lcom/drms/drms_drone/Service/BTService$3$5;-><init>(Lcom/drms/drms_drone/Service/BTService$3;[F[F[FLandroid/content/Intent;)V

    const-wide/16 v14, 0x1f4

    invoke-virtual {v12, v2, v14, v15}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 434
    .end local v4    # "p":[F
    .end local v5    # "i":[F
    .end local v6    # "d":[F
    :cond_f
    const-string v2, "disconnected bluetooth in Service"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 435
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 436
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->stop()V

    goto/16 :goto_0

    .line 439
    :cond_10
    const-string v2, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_12

    .line 440
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v2

    if-nez v2, :cond_11

    .line 441
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const-string v3, "\uc870\uc885\uae30 \ud654\uba74\uc73c\ub85c \uc774\ub3d9\ud569\ub2c8\ub2e4."

    const/4 v7, 0x0

    const/4 v12, 0x0

    invoke-virtual {v2, v3, v7, v12}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 443
    :cond_11
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 444
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const-string v3, "\uc124\uc815"

    const/4 v7, 0x0

    const/4 v12, 0x0

    invoke-virtual {v2, v3, v7, v12}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 447
    :cond_12
    const-string v2, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v9, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 448
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v2

    if-nez v2, :cond_13

    .line 449
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const-string v3, "\uc5b4\ud50c\ub9ac\ucf00\uc774\uc158\uc744 \uc885\ub8cc\ud569\ub2c8\ub2e4 "

    const/4 v7, 0x0

    const/4 v12, 0x0

    invoke-virtual {v2, v3, v7, v12}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 451
    :cond_13
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$400(Lcom/drms/drms_drone/Service/BTService;)I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    .line 452
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/drms/drms_drone/Service/BTService$3;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const-string v3, "\uc870\uc885\uae30 \ud654\uba74\uc744 \uc885\ub8cc\ud569\ub2c8\ub2e4."

    const/4 v7, 0x0

    const/4 v12, 0x0

    invoke-virtual {v2, v3, v7, v12}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    goto/16 :goto_0

    .line 329
    :catch_0
    move-exception v2

    goto/16 :goto_1

    .line 340
    :catch_1
    move-exception v2

    goto/16 :goto_2
.end method
