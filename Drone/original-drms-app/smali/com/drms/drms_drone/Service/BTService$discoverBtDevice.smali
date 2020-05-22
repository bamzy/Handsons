.class public Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;
.super Ljava/lang/Thread;
.source "BTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Service/BTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "discoverBtDevice"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Service/BTService;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 860
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 863
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 864
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$2000(Lcom/drms/drms_drone/Service/BTService;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$900(Lcom/drms/drms_drone/Service/BTService;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 865
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    if-eqz v2, :cond_6

    .line 866
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x2

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    .line 867
    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_4

    .line 868
    :cond_0
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1000(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x11

    if-ne v2, v3, :cond_3

    .line 869
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v3, Landroid/content/Intent;

    const-string v4, "discover bluetooth"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->sendBroadcast(Landroid/content/Intent;)V

    .line 870
    const-string v2, "BTService"

    const-string v3, "trying to connect BT"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 871
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$202(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 872
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    new-instance v3, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    iget-object v4, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    iget-object v5, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v5}, Lcom/drms/drms_drone/Service/BTService;->access$1200(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v5

    const-string v6, "MSP"

    invoke-direct {v3, v4, v5, v6}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;-><init>(Landroid/app/Service;Landroid/os/Handler;Ljava/lang/String;)V

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService;->access$202(Lcom/drms/drms_drone/Service/BTService;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 873
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 874
    .local v0, "btintent":Landroid/content/Intent;
    sget-object v2, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_ADDRESS:Ljava/lang/String;

    iget-object v3, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v3}, Lcom/drms/drms_drone/Service/BTService;->access$1000(Lcom/drms/drms_drone/Service/BTService;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 875
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getDeviceInfo(Landroid/content/Intent;)V

    .line 894
    .end local v0    # "btintent":Landroid/content/Intent;
    :cond_1
    :goto_1
    :try_start_0
    sget-wide v2, Lcom/drms/drms_drone/Service/BTService;->DISCOVER_LOOP:J

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 895
    :catch_0
    move-exception v1

    .line 896
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v2, "BTService"

    const-string v3, "InterruptedException during discovering BT Device"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 900
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :cond_2
    :goto_2
    return-void

    .line 878
    :cond_3
    const-string v2, "BTService"

    const-string v3, "Bluetooth Address is null"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 882
    :cond_4
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x4

    if-ne v2, v3, :cond_5

    .line 883
    const-string v2, "BTService"

    const-string v3, "Bluetooth is already connected"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 886
    :cond_5
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$discoverBtDevice;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$200(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v2

    const/4 v3, 0x3

    if-ne v2, v3, :cond_1

    .line 887
    const-string v2, "BTService"

    const-string v3, "Bluetooth is connecting"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 891
    :cond_6
    const-string v2, "BTService"

    const-string v3, "mBluetoothService is null"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method
