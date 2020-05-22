.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
.super Ljava/lang/Thread;
.source "BluetoothService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConnectThread"
.end annotation


# instance fields
.field private final mmDevice:Landroid/bluetooth/BluetoothDevice;

.field private final mmSocket:Landroid/bluetooth/BluetoothSocket;

.field final synthetic this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothDevice;)V
    .locals 4
    .param p2, "device"    # Landroid/bluetooth/BluetoothDevice;

    .prologue
    .line 228
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 229
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmDevice:Landroid/bluetooth/BluetoothDevice;

    .line 230
    const/4 v1, 0x0

    .line 233
    .local v1, "tmp":Landroid/bluetooth/BluetoothSocket;
    :try_start_0
    invoke-static {}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$000()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {p2, v2}, Landroid/bluetooth/BluetoothDevice;->createRfcommSocketToServiceRecord(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 237
    :goto_0
    iput-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    .line 238
    return-void

    .line 234
    :catch_0
    move-exception v0

    .line 235
    .local v0, "e":Ljava/io/IOException;
    const-string v2, "BluetoothService"

    const-string v3, "create() failed"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method


# virtual methods
.method public cancel()V
    .locals 3

    .prologue
    .line 271
    :try_start_0
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothSocket;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 275
    :goto_0
    return-void

    .line 272
    :catch_0
    move-exception v0

    .line 273
    .local v0, "e":Ljava/io/IOException;
    const-string v1, "BluetoothService"

    const-string v2, "close() of connect socket failed"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public run()V
    .locals 5

    .prologue
    .line 241
    const-string v2, "BluetoothService"

    const-string v3, "BEGIN mConnectThread"

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 242
    const-string v2, "ConnectThread"

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->setName(Ljava/lang/String;)V

    .line 244
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$100(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v2

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    .line 247
    :try_start_0
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothSocket;->connect()V

    .line 248
    const-string v2, "BluetoothService"

    const-string v3, "Connect Success"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 262
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    monitor-enter v3

    .line 263
    :try_start_1
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    const/4 v4, 0x0

    invoke-static {v2, v4}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$302(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    .line 264
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 265
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmDevice:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {v2, v3, v4}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->connected(Landroid/bluetooth/BluetoothSocket;Landroid/bluetooth/BluetoothDevice;)V

    .line 267
    :goto_0
    return-void

    .line 249
    :catch_0
    move-exception v0

    .line 250
    .local v0, "e":Ljava/io/IOException;
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->access$200(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V

    .line 251
    const-string v2, "BluetoothService"

    const-string v3, "Connect Fail"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 254
    :try_start_2
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->mmSocket:Landroid/bluetooth/BluetoothSocket;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothSocket;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1

    .line 259
    :goto_1
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->start()V

    goto :goto_0

    .line 255
    :catch_1
    move-exception v1

    .line 256
    .local v1, "e2":Ljava/io/IOException;
    const-string v2, "BluetoothService"

    const-string v3, "unable to close() socket during connection failure"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 264
    .end local v0    # "e":Ljava/io/IOException;
    .end local v1    # "e2":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    :try_start_3
    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v2
.end method
