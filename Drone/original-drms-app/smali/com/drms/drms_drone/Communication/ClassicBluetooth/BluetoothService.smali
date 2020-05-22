.class public Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
.super Ljava/lang/Object;
.source "BluetoothService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;,
        Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    }
.end annotation


# static fields
.field private static final DRS_PROTOCOL:I = 0x65

.field public static final MESSAGE_READ:I = 0x3

.field public static final MESSAGE_STATE_CHANGE:I = 0xa

.field public static final MESSAGE_WRITE:I = 0x2

.field public static final MODE_REQUEST:I = 0x1

.field private static final MY_UUID:Ljava/util/UUID;

.field private static final Multiwii_PROTOCOL:I = 0x66

.field private static final REQUEST_CONNECT_DEVICE:I = 0x1

.field private static final REQUEST_ENABLE_BT:I = 0x2

.field public static final STATE_CONNECTED:I = 0x4

.field public static final STATE_CONNECTING:I = 0x3

.field public static final STATE_DISCONNECTED:I = 0x8

.field public static final STATE_FAIL:I = 0x7

.field public static final STATE_LISTEN:I = 0x2

.field public static final STATE_NONE:I = 0x1

.field private static final STK_PROTOCOL:I = 0x67

.field private static final TAG:Ljava/lang/String; = "BluetoothService"


# instance fields
.field private MyAddress:Ljava/lang/String;

.field private Protocol:Ljava/lang/String;

.field public address1:Ljava/lang/String;

.field private btAdapter:Landroid/bluetooth/BluetoothAdapter;

.field public device:Landroid/bluetooth/BluetoothDevice;

.field private level_round:Ljava/lang/String;

.field private mActivity:Landroid/app/Activity;

.field private mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

.field private mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

.field private mHandler:Landroid/os/Handler;

.field public mMode:I

.field private mService:Landroid/app/Service;

.field public mState:I

.field private read_running:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-string v0, "00001101-0000-1000-8000-00805F9B34FB"

    invoke-static {v0}, Ljava/util/UUID;->fromString(Ljava/lang/String;)Ljava/util/UUID;

    move-result-object v0

    sput-object v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->MY_UUID:Ljava/util/UUID;

    return-void
.end method

.method public constructor <init>(Landroid/app/Service;Landroid/os/Handler;Ljava/lang/String;)V
    .locals 1
    .param p1, "mService"    # Landroid/app/Service;
    .param p2, "handler"    # Landroid/os/Handler;
    .param p3, "Protocol"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    iput v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I

    .line 71
    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->read_running:Z

    .line 73
    const-string v0, ""

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->MyAddress:Ljava/lang/String;

    .line 79
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mService:Landroid/app/Service;

    .line 80
    iput-object p2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mHandler:Landroid/os/Handler;

    .line 81
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->level_round:Ljava/lang/String;

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->level_round:Ljava/lang/String;

    .line 82
    iput-object p3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->Protocol:Ljava/lang/String;

    .line 84
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->btAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 85
    return-void
.end method

.method private ConnectLost()V
    .locals 1

    .prologue
    .line 429
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setState(I)V

    .line 430
    return-void
.end method

.method static synthetic access$000()Ljava/util/UUID;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->MY_UUID:Ljava/util/UUID;

    return-object v0
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/bluetooth/BluetoothAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->btAdapter:Landroid/bluetooth/BluetoothAdapter;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->connectFailed()V

    return-void
.end method

.method static synthetic access$302(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .param p1, "x1"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    return-object p1
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->read_running:Z

    return v0
.end method

.method static synthetic access$402(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->read_running:Z

    return p1
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->Protocol:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->ConnectLost()V

    return-void
.end method

.method private connectFailed()V
    .locals 1

    .prologue
    .line 425
    const/4 v0, 0x7

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setState(I)V

    .line 426
    return-void
.end method

.method private declared-synchronized setState(I)V
    .locals 3
    .param p1, "state"    # I

    .prologue
    .line 126
    monitor-enter p0

    :try_start_0
    const-string v0, "BluetoothService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "setState()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "->"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 127
    iput p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I

    .line 128
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mHandler:Landroid/os/Handler;

    const/16 v1, 0xa

    const/4 v2, -0x1

    invoke-virtual {v0, v1, p1, v2}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 130
    monitor-exit p0

    return-void

    .line 126
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public declared-synchronized connect(Landroid/bluetooth/BluetoothDevice;)V
    .locals 4
    .param p1, "device"    # Landroid/bluetooth/BluetoothDevice;

    .prologue
    const/4 v3, 0x3

    .line 157
    monitor-enter p0

    :try_start_0
    const-string v0, "BluetoothService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "connect to: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 159
    iget v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I

    if-ne v0, v3, :cond_0

    .line 160
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    if-nez v0, :cond_1

    .line 168
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    if-nez v0, :cond_2

    .line 175
    :goto_1
    new-instance v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-direct {v0, p0, p1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothDevice;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    .line 177
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->start()V

    .line 178
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setState(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 179
    monitor-exit p0

    return-void

    .line 163
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->cancel()V

    .line 164
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 157
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 171
    :cond_2
    :try_start_2
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->cancel()V

    .line 172
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public declared-synchronized connected(Landroid/bluetooth/BluetoothSocket;Landroid/bluetooth/BluetoothDevice;)V
    .locals 2
    .param p1, "socket"    # Landroid/bluetooth/BluetoothSocket;
    .param p2, "device"    # Landroid/bluetooth/BluetoothDevice;

    .prologue
    .line 182
    monitor-enter p0

    :try_start_0
    const-string v0, "BluetoothService"

    const-string v1, "connected"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 184
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    if-nez v0, :cond_0

    .line 191
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    if-nez v0, :cond_1

    .line 198
    :goto_1
    new-instance v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    invoke-direct {v0, p0, p1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/bluetooth/BluetoothSocket;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    .line 199
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->start()V

    .line 201
    const/4 v0, 0x4

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setState(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 202
    monitor-exit p0

    return-void

    .line 187
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->cancel()V

    .line 188
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 182
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 194
    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->cancel()V

    .line 195
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_1
.end method

.method public enableBluetooth()V
    .locals 2

    .prologue
    .line 104
    const-string v0, "BluetoothService"

    const-string v1, "Check the enable Bluetooth"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 105
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->btAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 106
    const-string v0, "BluetoothService"

    const-string v1, "Bluetooth Enable Now"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 107
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->scanDevice()V

    .line 115
    :goto_0
    return-void

    .line 109
    :cond_0
    const-string v0, "BluetoothService"

    const-string v1, "Bluetooth Enable Request"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 110
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getDeviceInfo(Landroid/content/Intent;)V
    .locals 4
    .param p1, "data"    # Landroid/content/Intent;

    .prologue
    .line 149
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    sget-object v2, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_ADDRESS:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 150
    .local v0, "address":Ljava/lang/String;
    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->address1:Ljava/lang/String;

    .line 151
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->btAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v1, v0}, Landroid/bluetooth/BluetoothAdapter;->getRemoteDevice(Ljava/lang/String;)Landroid/bluetooth/BluetoothDevice;

    move-result-object v1

    iput-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->device:Landroid/bluetooth/BluetoothDevice;

    .line 152
    const-string v1, "BluetoothService"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Get Device Info\naddress : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->device:Landroid/bluetooth/BluetoothDevice;

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->connect(Landroid/bluetooth/BluetoothDevice;)V

    .line 154
    return-void
.end method

.method public getDeviceState()Z
    .locals 2

    .prologue
    .line 92
    const-string v0, "BluetoothService"

    const-string v1, "Check the Bluetooth support"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 94
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->btAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-nez v0, :cond_0

    .line 95
    const-string v0, "BluetoothService"

    const-string v1, "Bluetooth is not available"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 96
    const/4 v0, 0x0

    .line 99
    :goto_0
    return v0

    .line 98
    :cond_0
    const-string v0, "BluetoothService"

    const-string v1, "Bluetooth is available"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 99
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public declared-synchronized getState()I
    .locals 1

    .prologue
    .line 133
    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public readMSP()V
    .locals 2

    .prologue
    .line 421
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    const-string v1, "MSP"

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->access$800(Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;Ljava/lang/String;)V

    .line 422
    return-void
.end method

.method public scanDevice()V
    .locals 3

    .prologue
    .line 118
    const-string v1, "BluetoothService"

    const-string v2, "SCAN DEVICE"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mActivity:Landroid/app/Activity;

    const-class v2, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 120
    .local v0, "serverIntent":Landroid/content/Intent;
    const-string v1, "request scan device"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 123
    return-void
.end method

.method public setProtocol(Ljava/lang/String;)V
    .locals 0
    .param p1, "protocol"    # Ljava/lang/String;

    .prologue
    .line 88
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->Protocol:Ljava/lang/String;

    .line 89
    return-void
.end method

.method public setReadRunning(Z)V
    .locals 0
    .param p1, "read_running"    # Z

    .prologue
    .line 433
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->read_running:Z

    .line 434
    return-void
.end method

.method public setmHandler(Landroid/os/Handler;)V
    .locals 0
    .param p1, "mHandler"    # Landroid/os/Handler;

    .prologue
    .line 437
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mHandler:Landroid/os/Handler;

    .line 438
    return-void
.end method

.method public declared-synchronized start()V
    .locals 2

    .prologue
    .line 137
    monitor-enter p0

    :try_start_0
    const-string v0, "BluetoothService"

    const-string v1, "start"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 146
    :goto_0
    monitor-exit p0

    return-void

    .line 143
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->cancel()V

    .line 144
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 137
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stop()V
    .locals 2

    .prologue
    .line 205
    monitor-enter p0

    :try_start_0
    const-string v0, "BluetoothService"

    const-string v1, "STOP"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 206
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->read_running:Z

    .line 208
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;->cancel()V

    .line 210
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectThread;

    .line 213
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    if-eqz v0, :cond_1

    .line 214
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->cancel()V

    .line 215
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    .line 218
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->device:Landroid/bluetooth/BluetoothDevice;

    .line 219
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setState(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 220
    monitor-exit p0

    return-void

    .line 205
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public write([BI)V
    .locals 3
    .param p1, "out"    # [B
    .param p2, "mode"    # I

    .prologue
    .line 412
    monitor-enter p0

    .line 413
    :try_start_0
    iget v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mState:I

    const/4 v2, 0x4

    if-eq v1, v2, :cond_0

    .line 414
    monitor-exit p0

    .line 418
    :goto_0
    return-void

    .line 415
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->mConnectedThread:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;

    .line 416
    .local v0, "r":Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 417
    invoke-virtual {v0, p1, p2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;->write([BI)V

    goto :goto_0

    .line 416
    .end local v0    # "r":Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService$ConnectedThread;
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method
