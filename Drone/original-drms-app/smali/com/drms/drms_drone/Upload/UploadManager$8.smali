.class Lcom/drms/drms_drone/Upload/UploadManager$8;
.super Landroid/os/Handler;
.source "UploadManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Upload/UploadManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadManager;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 363
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 12
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/16 v11, 0xff

    const/4 v10, 0x1

    const/high16 v8, 0x447a0000    # 1000.0f

    const/4 v9, 0x0

    .line 366
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 367
    iget v6, p1, Landroid/os/Message;->what:I

    sparse-switch v6, :sswitch_data_0

    .line 478
    :cond_0
    :goto_0
    :sswitch_0
    return-void

    .line 369
    :sswitch_1
    const-string v6, "UplaodManager"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "MESSAGE_STATE_CHANGE:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 371
    iget v6, p1, Landroid/os/Message;->arg1:I

    sparse-switch v6, :sswitch_data_1

    goto :goto_0

    .line 378
    :sswitch_2
    const-string v6, "UplaodManager"

    const-string v7, "bluetooth disconnected"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 379
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$700(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 380
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 381
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v6

    iput-boolean v9, v6, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    .line 382
    :cond_1
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v9}, Lcom/drms/drms_drone/Upload/UploadManager;->access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 383
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    const/16 v7, 0x3d

    const/16 v8, 0x5f

    invoke-static {v11, v11, v7, v8}, Landroid/graphics/Color;->argb(IIII)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 384
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "\ube14\ub8e8\ud22c\uc2a4 \uc5f0\uacb0\uc774 \ub04a\uc5b4\uc838 \uc885\ub8cc\ud569\ub2c8\ub2e4."

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 385
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    array-length v6, v6

    if-ge v3, v6, :cond_2

    .line 386
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    aget-object v6, v6, v3

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 385
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 387
    :cond_2
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;

    move-result-object v6

    new-instance v7, Lcom/drms/drms_drone/Upload/UploadManager$8$1;

    invoke-direct {v7, p0}, Lcom/drms/drms_drone/Upload/UploadManager$8$1;-><init>(Lcom/drms/drms_drone/Upload/UploadManager$8;)V

    const-wide/16 v8, 0x7d0

    invoke-virtual {v6, v7, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 400
    .end local v3    # "i":I
    :sswitch_3
    iget-object v6, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v6, [B

    move-object v1, v6

    check-cast v1, [B

    .line 401
    .local v1, "data":[B
    const-string v6, "UplaodManager"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "stk500 : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v8}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 402
    const-string v6, "UplaodManager"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "stkHandler : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v8}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v8

    invoke-virtual {v8}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->getStk500_handler()Landroid/os/Handler;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 403
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->getStk500_handler()Landroid/os/Handler;

    move-result-object v6

    const/16 v7, 0x15

    iget-object v8, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v8}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1600(Lcom/drms/drms_drone/Upload/UploadManager;)B

    move-result v8

    const/4 v9, -0x1

    invoke-virtual {v6, v7, v8, v9, v1}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v6

    invoke-virtual {v6}, Landroid/os/Message;->sendToTarget()V

    .line 404
    const/4 v4, 0x0

    .line 406
    .local v4, "index":I
    goto/16 :goto_0

    .line 409
    .end local v1    # "data":[B
    .end local v4    # "index":I
    :sswitch_4
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    iget v7, p1, Landroid/os/Message;->arg1:I

    int-to-byte v7, v7

    invoke-static {v6, v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1602(Lcom/drms/drms_drone/Upload/UploadManager;B)B

    goto/16 :goto_0

    .line 414
    :sswitch_5
    iget v6, p1, Landroid/os/Message;->arg1:I

    packed-switch v6, :pswitch_data_0

    .line 451
    :pswitch_0
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1800(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v6

    const/4 v7, 0x4

    if-ne v6, v7, :cond_0

    .line 452
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$000(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 453
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v9}, Lcom/drms/drms_drone/Upload/UploadManager;->access$902(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 454
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v10}, Lcom/drms/drms_drone/Upload/UploadManager;->access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 455
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1900(Lcom/drms/drms_drone/Upload/UploadManager;)V

    .line 457
    :cond_3
    iget v6, p1, Landroid/os/Message;->arg1:I

    mul-int/lit8 v6, v6, 0x64

    iget v7, p1, Landroid/os/Message;->arg2:I

    div-int v5, v6, v7

    .line 458
    .local v5, "progress":I
    iget v6, p1, Landroid/os/Message;->arg1:I

    int-to-float v6, v6

    div-float v0, v6, v8

    .line 459
    .local v0, "current_byte":F
    iget v6, p1, Landroid/os/Message;->arg2:I

    int-to-float v6, v6

    div-float v2, v6, v8

    .line 461
    .local v2, "finished_byte":F
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "\uc5c5\ub85c\ub4dc \uc911... ( "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " % \uc644\ub8cc )"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 462
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$2000(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    move-result-object v6

    invoke-virtual {v6, v5}, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->setProgress(I)V

    .line 463
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$2000(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->invalidate()V

    goto/16 :goto_0

    .line 416
    .end local v0    # "current_byte":F
    .end local v2    # "finished_byte":F
    .end local v5    # "progress":I
    :pswitch_1
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v9}, Lcom/drms/drms_drone/Upload/UploadManager;->access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 417
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v9}, Lcom/drms/drms_drone/Upload/UploadManager;->access$302(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 419
    const-wide/16 v6, 0x1f4

    :try_start_0
    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 421
    :goto_2
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-result-object v6

    iput-boolean v9, v6, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->running:Z

    .line 422
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "\uc5c5\ub85c\ub4dc\uac00 \uc644\ub8cc \ub418\uc5c8\uc2b5\ub2c8\ub2e4."

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 423
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_3
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    array-length v6, v6

    if-ge v3, v6, :cond_0

    .line 424
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    aget-object v6, v6, v3

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 423
    add-int/lit8 v3, v3, 0x1

    goto :goto_3

    .line 429
    .end local v3    # "i":I
    :pswitch_2
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v9}, Lcom/drms/drms_drone/Upload/UploadManager;->access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    goto/16 :goto_0

    .line 434
    :pswitch_3
    const-string v6, "UplaodManager"

    const-string v7, "Try Again to Upload"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 435
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$600(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    goto/16 :goto_0

    .line 439
    :pswitch_4
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0c002b

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 440
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "initializing..."

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 441
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6, v10}, Lcom/drms/drms_drone/Upload/UploadManager;->access$902(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 443
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1700(Lcom/drms/drms_drone/Upload/UploadManager;)V

    goto/16 :goto_0

    .line 447
    :pswitch_5
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;

    move-result-object v6

    const-string v7, "\uc5c5\ub85c\ub4dc \uc885\ub8cc \uc694\uccad \uc911\uc785\ub2c8\ub2e4."

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 471
    :sswitch_6
    const-string v6, "UplaodManager"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "state on : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p1, Landroid/os/Message;->arg1:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 472
    const/4 v3, 0x0

    .restart local v3    # "i":I
    :goto_4
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    array-length v6, v6

    if-ge v3, v6, :cond_4

    .line 473
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    aget-object v6, v6, v3

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1200(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 472
    add-int/lit8 v3, v3, 0x1

    goto :goto_4

    .line 475
    :cond_4
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v6}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v6

    iget v7, p1, Landroid/os/Message;->arg1:I

    aget-object v6, v6, v7

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager$8;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v7}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1300(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    .line 420
    .end local v3    # "i":I
    :catch_0
    move-exception v6

    goto/16 :goto_2

    .line 367
    nop

    :sswitch_data_0
    .sparse-switch
        0x3 -> :sswitch_3
        0x4 -> :sswitch_6
        0x7 -> :sswitch_1
        0x14 -> :sswitch_4
        0x17 -> :sswitch_5
    .end sparse-switch

    .line 371
    :sswitch_data_1
    .sparse-switch
        0x3 -> :sswitch_0
        0x8 -> :sswitch_2
    .end sparse-switch

    .line 414
    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method
