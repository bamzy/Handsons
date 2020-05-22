.class public Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;
.super Landroid/app/Activity;
.source "DeviceListActivity.java"


# static fields
.field private static final D:Z = true

.field public static EXTRA_DEVICE_ADDRESS:Ljava/lang/String; = null

.field public static EXTRA_DEVICE_NAME:Ljava/lang/String; = null

.field private static final TAG:Ljava/lang/String; = "DeviceListActivity"


# instance fields
.field private DiscoverCount:I

.field private mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

.field private mDeviceClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private mDiscoveredAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

.field private mPairedAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

.field private final mReceiver:Landroid/content/BroadcastReceiver;

.field private newDevicesListView:Landroid/widget/ListView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-string v0, "device_address"

    sput-object v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_ADDRESS:Ljava/lang/String;

    .line 44
    const-string v0, "device_name"

    sput-object v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 54
    const/4 v0, 0x0

    iput v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->DiscoverCount:I

    .line 184
    new-instance v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mDeviceClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 210
    new-instance v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->doDiscovery()V

    return-void
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/bluetooth/BluetoothAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)I
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->DiscoverCount:I

    return v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;
    .param p1, "x1"    # I

    .prologue
    .line 35
    iput p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->DiscoverCount:I

    return p1
.end method

.method static synthetic access$208(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)I
    .locals 2
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->DiscoverCount:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->DiscoverCount:I

    return v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mDiscoveredAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->newDevicesListView:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mDeviceClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method private doDiscovery()V
    .locals 4

    .prologue
    .line 149
    const-string v2, "DeviceListActivity"

    const-string v3, "doDiscovery()"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setProgressBarIndeterminateVisibility(Z)V

    .line 153
    const v2, 0x7f080027

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setTitle(I)V

    .line 156
    const v2, 0x7f0d0062

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 157
    .local v1, "scan_button":Landroid/widget/Button;
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 158
    const v2, 0x7f0d0060

    invoke-virtual {p0, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 159
    .local v0, "discover_box":Landroid/widget/LinearLayout;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 162
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothAdapter;->isDiscovering()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 163
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v2}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    .line 168
    :cond_0
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 178
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 181
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 276
    invoke-super {p0}, Landroid/app/Activity;->finish()V

    .line 277
    const v0, 0x7f05000c

    const v1, 0x7f05000a

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->overridePendingTransition(II)V

    .line 278
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v9, 0x400

    .line 58
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 60
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getWindow()Landroid/view/Window;

    move-result-object v8

    invoke-virtual {v8, v9, v9}, Landroid/view/Window;->setFlags(II)V

    .line 61
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getWindow()Landroid/view/Window;

    move-result-object v8

    invoke-virtual {v8}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v8

    const/16 v9, 0x1002

    invoke-virtual {v8, v9}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 65
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 70
    .local v3, "intent":Landroid/content/Intent;
    const v8, 0x7f04001c

    invoke-virtual {p0, v8}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setContentView(I)V

    .line 73
    const/4 v8, 0x0

    invoke-virtual {p0, v8}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setResult(I)V

    .line 76
    const v8, 0x7f0d0062

    invoke-virtual {p0, v8}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Button;

    .line 77
    .local v7, "scanButton":Landroid/widget/Button;
    new-instance v8, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$1;

    invoke-direct {v8, p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$1;-><init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    invoke-virtual {v7, v8}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 89
    new-instance v8, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    invoke-direct {v8, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;-><init>(Landroid/content/Context;)V

    iput-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mPairedAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    .line 90
    new-instance v8, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    invoke-direct {v8, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;-><init>(Landroid/content/Context;)V

    iput-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mDiscoveredAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    .line 94
    const v8, 0x7f0d005f

    invoke-virtual {p0, v8}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ListView;

    .line 95
    .local v6, "pairedListView":Landroid/widget/ListView;
    iget-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mPairedAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    invoke-virtual {v6, v8}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 96
    iget-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mDeviceClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v6, v8}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 99
    const v8, 0x7f0d0061

    invoke-virtual {p0, v8}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/ListView;

    iput-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->newDevicesListView:Landroid/widget/ListView;

    .line 105
    new-instance v2, Landroid/content/IntentFilter;

    invoke-direct {v2}, Landroid/content/IntentFilter;-><init>()V

    .line 106
    .local v2, "filter":Landroid/content/IntentFilter;
    const-string v8, "android.bluetooth.device.action.FOUND"

    invoke-virtual {v2, v8}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 107
    const-string v8, "android.bluetooth.adapter.action.DISCOVERY_FINISHED"

    invoke-virtual {v2, v8}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 109
    iget-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v8, v2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 112
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v8

    iput-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    .line 115
    iget-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v8}, Landroid/bluetooth/BluetoothAdapter;->getBondedDevices()Ljava/util/Set;

    move-result-object v5

    .line 118
    .local v5, "pairedDevices":Ljava/util/Set;, "Ljava/util/Set<Landroid/bluetooth/BluetoothDevice;>;"
    invoke-interface {v5}, Ljava/util/Set;->size()I

    move-result v8

    if-lez v8, :cond_0

    .line 119
    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/bluetooth/BluetoothDevice;

    .line 120
    .local v1, "device":Landroid/bluetooth/BluetoothDevice;
    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v0

    .line 122
    .local v0, "address":Ljava/lang/String;
    iget-object v9, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mPairedAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    new-instance v10, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f03000f

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v11

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v1}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v10, v11, v12, v13}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v9, v10}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;)V

    goto :goto_0

    .line 127
    .end local v0    # "address":Ljava/lang/String;
    .end local v1    # "device":Landroid/bluetooth/BluetoothDevice;
    :cond_0
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f080025

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    .line 128
    .local v4, "noDevices":Ljava/lang/String;
    iget-object v8, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mPairedAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    new-instance v9, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f03000c

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v10

    const-string v11, "no device"

    const-string v12, ""

    invoke-direct {v9, v10, v11, v12}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v8, v9}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;)V

    .line 130
    .end local v4    # "noDevices":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 134
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 137
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mBtAdapter:Landroid/bluetooth/BluetoothAdapter;

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    .line 142
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->mReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 143
    return-void
.end method
