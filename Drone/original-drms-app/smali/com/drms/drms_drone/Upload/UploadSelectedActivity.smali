.class public Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
.super Landroid/support/v7/app/AppCompatActivity;
.source "UploadSelectedActivity.java"


# static fields
.field public static final REQUEST_HEX_GY521:I = 0x3

.field public static final REQUEST_HEX_GY85:I = 0x4

.field public static final REQUEST_HEX_GY86:I = 0x5

.field public static final REQUEST_QUAD_GY521:I = 0x0

.field public static final REQUEST_QUAD_GY85:I = 0x1

.field public static final REQUEST_QUAD_GY86:I = 0x2

.field private static final TAG:Ljava/lang/String; = "UploadSelectActivity"


# instance fields
.field private final BTConnection:Landroid/content/ServiceConnection;

.field private HexItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private MainReceiver:Landroid/content/BroadcastReceiver;

.field private QuadItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

.field private hex_contents:Landroid/widget/ListView;

.field private mBTService:Lcom/drms/drms_drone/Service/BTService;

.field private mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

.field private mHandler:Landroid/os/Handler;

.field private mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

.field private quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

.field private quad_contents:Landroid/widget/ListView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Landroid/support/v7/app/AppCompatActivity;-><init>()V

    .line 85
    new-instance v0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$1;-><init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->QuadItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 115
    new-instance v0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;-><init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->HexItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 144
    new-instance v0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$3;-><init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mHandler:Landroid/os/Handler;

    .line 151
    new-instance v0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$4;-><init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->BTConnection:Landroid/content/ServiceConnection;

    .line 218
    new-instance v0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$5;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$5;-><init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Sound/SoundManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    return-object v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Sound/SoundManager;)Lcom/drms/drms_drone/Sound/SoundManager;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Sound/SoundManager;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mSoundManager:Lcom/drms/drms_drone/Sound/SoundManager;

    return-object p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object v0
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object p1
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    return-object v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/FileManagement/FileManagement;)Lcom/drms/drms_drone/FileManagement/FileManagement;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/FileManagement/FileManagement;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mFileManagement:Lcom/drms/drms_drone/FileManagement/FileManagement;

    return-object p1
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Service/BTService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method

.method static synthetic access$302(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/Service/BTService;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
    .param p1, "x1"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mBTService:Lcom/drms/drms_drone/Service/BTService;

    return-object p1
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 227
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 229
    .local v0, "filter":Landroid/content/IntentFilter;
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 230
    return-void
.end method

.method private startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V
    .locals 7
    .param p2, "serviceConnection"    # Landroid/content/ServiceConnection;
    .param p3, "extras"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/content/ServiceConnection;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 175
    .local p1, "service":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v4, Landroid/content/Intent;

    invoke-direct {v4, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 176
    .local v4, "startService":Landroid/content/Intent;
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/os/Bundle;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 177
    invoke-virtual {p3}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v3

    .line 178
    .local v3, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 179
    .local v2, "key":Ljava/lang/String;
    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 180
    .local v1, "extra":Ljava/lang/String;
    invoke-virtual {v4, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_0

    .line 184
    .end local v1    # "extra":Ljava/lang/String;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 185
    .local v0, "bindingIntent":Landroid/content/Intent;
    const/4 v5, 0x1

    invoke-virtual {p0, v0, p2, v5}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 186
    return-void
.end method


# virtual methods
.method public finish()V
    .locals 2

    .prologue
    .line 190
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->finish()V

    .line 191
    const v0, 0x7f05000c

    const v1, 0x7f05000a

    invoke-virtual {p0, v0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->overridePendingTransition(II)V

    .line 192
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
        .annotation build Landroid/support/annotation/Nullable;
        .end annotation
    .end param

    .prologue
    const v7, 0x7f030029

    const v6, 0x7f030013

    .line 56
    invoke-super {p0, p1}, Landroid/support/v7/app/AppCompatActivity;->onCreate(Landroid/os/Bundle;)V

    .line 57
    const v1, 0x7f040025

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->setContentView(I)V

    .line 60
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 61
    .local v0, "requestUpload":Landroid/content/Intent;
    const-string v1, "request upload display"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 62
    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 64
    const v1, 0x7f0d0088

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quad_contents:Landroid/widget/ListView;

    .line 65
    const v1, 0x7f0d0089

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hex_contents:Landroid/widget/ListView;

    .line 67
    new-instance v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    .line 68
    new-instance v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    .line 70
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "Quad + GY-521"

    const-string v5, "ACC + GYRO"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 71
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "Quad + GY-85"

    const-string v5, "ACC + GYRO + MAG"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 72
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "Quad + GY-86"

    const-string v5, "ACC + GYRO + MAG + BARO"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 74
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "HEX + GY-521"

    const-string v5, "ACC + GYRO"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 75
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "HEX + GY-85"

    const-string v5, "ACC + GYRO"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 76
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    new-instance v2, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const-string v4, "HEX + GY-86"

    const-string v5, "ACC + GYRO"

    invoke-direct {v2, v3, v4, v5}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 78
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quad_contents:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quadAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 79
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->quad_contents:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->QuadItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 80
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hex_contents:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hexAdapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 81
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->hex_contents:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->HexItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 83
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 208
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onPause()V

    .line 209
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    .line 196
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onResume()V

    .line 197
    invoke-direct {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->setFilter()V

    .line 198
    const-class v0, Lcom/drms/drms_drone/Service/BTService;

    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->BTConnection:Landroid/content/ServiceConnection;

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->startService(Ljava/lang/Class;Landroid/content/ServiceConnection;Landroid/os/Bundle;)V

    .line 200
    invoke-virtual {p0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x1002

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 204
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 213
    invoke-super {p0}, Landroid/support/v7/app/AppCompatActivity;->onStop()V

    .line 214
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->MainReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 215
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->BTConnection:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 216
    return-void
.end method
