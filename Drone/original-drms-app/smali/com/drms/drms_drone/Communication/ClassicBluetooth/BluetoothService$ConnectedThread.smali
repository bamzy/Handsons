.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
.super Ljava/lang/Thread;
.source "BluetoothService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConnectedThread"
.end annotation


# instance fields
.field private final mmInStream:Ljava/io/InputStream;

.field private final mmOutStream:Ljava/io/OutputStream;

.field private final mmSocket:Landroid/bluetooth/BluetoothSocket;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothSocket;)V
    .locals 5
    .param p2, "socket"    # Landroid/bluetooth/BluetoothSocket;

    .prologue
    .line 287
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 288
    const-string v3, "BluetoothService"

    const-string v4, "create ConnectedThread"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    .line 290
    const/4 v1, 0x0

    .line 291
    .local v1, "tmpIn":Ljava/io/InputStream;
    const/4 v2, 0x0

    .line 294
    .local v2, "tmpOut":Ljava/io/OutputStream;
    :try_start_0
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    .line 295
    invoke-virtual {p2}, Landroid/bluetooth/BluetoothSocket;->getOutputStream()Ljava/io/OutputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 300
    :goto_0
    iput-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    .line 301
    iput-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmOutStream:Ljava/io/OutputStream;

    .line 302
    return-void

    .line 296
    :catch_0
    move-exception v0

    .line 297
    .local v0, "e":Ljava/io/IOException;
    const-string v3, "BluetoothService"

    const-string v4, "temp socket net created"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 282
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->read_protocol(Ljava/lang/String;)V

    return-void
.end method

.method private read_protocol(Ljava/lang/String;)V
    .locals 22
    .param p1, "protocol"    # Ljava/lang/String;

    .prologue
    .line 314
    const-string v18, "STK"

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_2

    .line 316
    const/16 v18, 0x2

    :try_start_0
    move/from16 v0, v18

    new-array v8, v0, [B

    .line 318
    .local v8, "data":[B
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v5

    .line 319
    .local v5, "SYNC_CHECK":I
    const/16 v18, 0x0

    int-to-byte v0, v5

    move/from16 v19, v0

    aput-byte v19, v8, v18

    .line 320
    int-to-byte v0, v5

    move/from16 v18, v0

    const/16 v19, 0x14

    move/from16 v0, v18

    move/from16 v1, v19

    if-ne v0, v1, :cond_0

    .line 321
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v4

    .line 322
    .local v4, "RESP_OK":I
    const/16 v18, 0x1

    int-to-byte v0, v4

    move/from16 v19, v0

    aput-byte v19, v8, v18

    .line 325
    .end local v4    # "RESP_OK":I
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$600(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/os/Handler;

    move-result-object v18

    const/16 v19, 0x3

    const/16 v20, -0x1

    const/16 v21, -0x1

    move-object/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    move/from16 v3, v21

    invoke-virtual {v0, v1, v2, v3, v8}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/os/Message;->sendToTarget()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 382
    .end local v5    # "SYNC_CHECK":I
    .end local v8    # "data":[B
    :cond_1
    :goto_0
    return-void

    .line 326
    :catch_0
    move-exception v9

    .line 327
    .local v9, "e":Ljava/io/IOException;
    const-string v18, "BluetoothService"

    const-string v19, "disconnected"

    invoke-static/range {v18 .. v19}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 328
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$700(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    .line 329
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-static/range {v18 .. v19}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$402(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Z)Z

    .line 331
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$600(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/os/Handler;

    move-result-object v18

    const/16 v19, 0xa

    const/16 v20, 0x8

    const/16 v21, -0x1

    invoke-virtual/range {v18 .. v21}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/os/Message;->sendToTarget()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 332
    :catch_1
    move-exception v18

    goto :goto_0

    .line 336
    .end local v9    # "e":Ljava/io/IOException;
    :cond_2
    const-string v18, "MSP"

    move-object/from16 v0, p1

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v18

    if-eqz v18, :cond_1

    .line 337
    const/4 v10, 0x0

    .line 338
    .local v10, "header":C
    const/16 v18, 0x2

    move/from16 v0, v18

    new-array v11, v0, [I

    .line 339
    .local v11, "header_array":[I
    const/16 v17, 0x0

    .line 340
    .local v17, "sizeofdata":I
    const/4 v7, 0x0

    .line 341
    .local v7, "command":I
    const/4 v6, 0x0

    .line 343
    .local v6, "checksum":I
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v18

    move/from16 v0, v18

    int-to-char v10, v0

    const/16 v18, 0x24

    move/from16 v0, v18

    if-ne v10, v0, :cond_1

    .line 344
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    const/16 v18, 0x2

    move/from16 v0, v18

    if-ge v12, v0, :cond_3

    .line 345
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v18

    aput v18, v11, v12

    .line 344
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 347
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v17

    .line 348
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v7

    .line 349
    move/from16 v0, v17

    new-array v0, v0, [I

    move-object/from16 v16, v0

    .line 351
    .local v16, "payload":[I
    const/4 v12, 0x0

    :goto_2
    move/from16 v0, v17

    if-ge v12, v0, :cond_4

    .line 352
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v18

    aput v18, v16, v12

    .line 351
    add-int/lit8 v12, v12, 0x1

    goto :goto_2

    .line 355
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmInStream:Ljava/io/InputStream;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Ljava/io/InputStream;->read()I

    move-result v6

    .line 357
    add-int/lit8 v18, v17, 0x6

    move/from16 v0, v18

    new-array v15, v0, [B

    .line 358
    .local v15, "msp_payload":[B
    const/4 v13, 0x0

    .line 359
    .local v13, "index":I
    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .local v14, "index":I
    const/16 v18, 0x24

    aput-byte v18, v15, v13

    .line 360
    const/4 v12, 0x0

    :goto_3
    const/16 v18, 0x2

    move/from16 v0, v18

    if-ge v12, v0, :cond_5

    .line 361
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget v18, v11, v12

    move/from16 v0, v18

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v15, v14

    .line 360
    add-int/lit8 v12, v12, 0x1

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    goto :goto_3

    .line 362
    :cond_5
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    move/from16 v0, v17

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v15, v14

    .line 363
    add-int/lit8 v14, v13, 0x1

    .end local v13    # "index":I
    .restart local v14    # "index":I
    int-to-byte v0, v7

    move/from16 v18, v0

    aput-byte v18, v15, v13

    .line 364
    const/4 v12, 0x0

    :goto_4
    move/from16 v0, v17

    if-ge v12, v0, :cond_6

    .line 365
    add-int/lit8 v13, v14, 0x1

    .end local v14    # "index":I
    .restart local v13    # "index":I
    aget v18, v16, v12

    move/from16 v0, v18

    int-to-byte v0, v0

    move/from16 v18, v0

    aput-byte v18, v15, v14

    .line 364
    add-int/lit8 v12, v12, 0x1

    move v14, v13

    .end local v13    # "index":I
    .restart local v14    # "index":I
    goto :goto_4

    .line 366
    :cond_6
    int-to-byte v0, v6

    move/from16 v18, v0

    aput-byte v18, v15, v14

    .line 368
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$600(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/os/Handler;

    move-result-object v18

    const/16 v19, 0x66

    const/16 v20, -0x1

    move-object/from16 v0, v18

    move/from16 v1, v19

    move/from16 v2, v20

    invoke-virtual {v0, v1, v14, v2, v15}, Landroid/os/Handler;->obtainMessage(IIILjava/lang/Object;)Landroid/os/Message;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/os/Message;->sendToTarget()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_2

    goto/16 :goto_0

    .line 371
    .end local v12    # "i":I
    .end local v14    # "index":I
    .end local v15    # "msp_payload":[B
    .end local v16    # "payload":[I
    :catch_2
    move-exception v9

    .line 372
    .restart local v9    # "e":Ljava/io/IOException;
    const-string v18, "BluetoothService"

    const-string v19, "disconnected"

    invoke-static/range {v18 .. v19}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 373
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$600(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/os/Handler;

    move-result-object v18

    const/16 v19, 0xa

    const/16 v20, 0x8

    const/16 v21, -0x1

    invoke-virtual/range {v18 .. v21}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Landroid/os/Message;->sendToTarget()V

    .line 374
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    invoke-static/range {v18 .. v18}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$700(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    .line 375
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    invoke-static/range {v18 .. v19}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$402(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Z)Z

    goto/16 :goto_0
.end method


# virtual methods
.method public cancel()V
    .locals 3

    .prologue
    .line 400
    :try_start_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothSocket;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 404
    :goto_0
    return-void

    .line 401
    :catch_0
    move-exception v0

    .line 402
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BluetoothService"

    const-string v2, "close() of connect socket failed"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public run()V
    .locals 2

    .prologue
    .line 305
    const-string v0, "BluetoothService"

    const-string v1, "BEGIN mConnectedThread"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 307
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 308
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$500(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->read_protocol(Ljava/lang/String;)V

    goto :goto_0

    .line 311
    :cond_0
    return-void
.end method

.method public write([BI)V
    .locals 3
    .param p1, "buffer"    # [B
    .param p2, "mode"    # I

    .prologue
    .line 386
    :try_start_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->mmOutStream:Ljava/io/OutputStream;

    invoke-virtual {v1, p1}, Ljava/io/OutputStream;->write([B)V

    .line 387
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    iput p2, v1, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mMode:I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 389
    const/4 v1, 0x1

    if-ne p2, v1, :cond_0

    .line 396
    :cond_0
    :goto_0
    return-void

    .line 392
    :catch_0
    move-exception v0

    .line 393
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BluetoothService"

    const-string v2, "Exception during write"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
