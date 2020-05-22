.class public Lcom/drms/drms_drone/Upload/UploadManager;
.super Ljava/lang/Object;
.source "UploadManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;
    }
.end annotation


# static fields
.field public static final D:Z = true

.field private static final MESSAGE_READ:I = 0x3

.field private static final MESSAGE_STATE_CHANGE:I = 0x7

.field private static final MESSAGE_WRITE:I = 0x2

.field private static final ORIENT_COMMAND:I = 0x14

.field private static final RECEIVED_MESSAGE:I = 0x15

.field private static final REQUEST_CONNECT_DEVICE:I = 0x1

.field private static final REQUEST_ENABLE_BT:I = 0x2

.field private static final TAG:Ljava/lang/String; = "UplaodManager"

.field private static final UPDATE_STATE:I = 0x4

.field public static final UPLOAD_END:I = 0x4

.field public static final UPLOAD_FAILED:I = -0x1

.field private static final UPLOAD_PROGRESS:I = 0x16

.field public static final UPLOAD_START:I = 0x3

.field private static final UPLOAD_STATE:I = 0x17

.field public static final UPLOAD_SUCCESS:I = 0x1


# instance fields
.field private BT_Connecting_tries:I

.field private arrowOff:Landroid/graphics/Bitmap;

.field private arrowOffDrawable:Landroid/graphics/drawable/BitmapDrawable;

.field private arrowOn:Landroid/graphics/Bitmap;

.field private arrowOnDrawable:Landroid/graphics/drawable/BitmapDrawable;

.field private bt_address:Ljava/lang/String;

.field private command_data:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private dialog:Landroid/support/v7/app/AlertDialog;

.field private hexData:Ljava/lang/String;

.field private information:Landroid/widget/TextView;

.field private init_state:Z

.field private isInitializing:Z

.field private isUploading:Z

.field private mActivity:Landroid/app/Activity;

.field private mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

.field private mOutStringBuffer:Ljava/lang/StringBuffer;

.field private notConnected:Landroid/graphics/Bitmap;

.field private notConnectedDrawable:Landroid/graphics/drawable/BitmapDrawable;

.field private orient_command:B

.field private progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

.field private progresslayout:Landroid/widget/LinearLayout;

.field private request:I

.field private startUpload:Z

.field private state:[Landroid/widget/ImageView;

.field private stateOnIndex:I

.field private stk500:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

.field private uploadManagerHandler:Landroid/os/Handler;

.field private uploadSuccess:Z

.field private upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Ljava/lang/String;I)V
    .locals 16
    .param p1, "mActivity"    # Landroid/app/Activity;
    .param p2, "mBluetoothService"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .param p3, "bt_address"    # Ljava/lang/String;
    .param p4, "request"    # I

    .prologue
    .line 101
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->isUploading:Z

    .line 64
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadSuccess:Z

    .line 65
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->stateOnIndex:I

    .line 66
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->isInitializing:Z

    .line 67
    const/4 v13, 0x1

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->startUpload:Z

    .line 84
    const/4 v13, 0x3

    new-array v13, v13, [Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    .line 90
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    .line 332
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-boolean v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->init_state:Z

    .line 361
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->BT_Connecting_tries:I

    .line 363
    new-instance v13, Lcom/drms/drms_drone/Upload/UploadManager$8;

    move-object/from16 v0, p0

    invoke-direct {v13, v0}, Lcom/drms/drms_drone/Upload/UploadManager$8;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadManagerHandler:Landroid/os/Handler;

    .line 103
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    .line 104
    move-object/from16 v0, p3

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/drms/drms_drone/Upload/UploadManager;->bt_address:Ljava/lang/String;

    .line 105
    move-object/from16 v0, p2

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/drms/drms_drone/Upload/UploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 106
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadManagerHandler:Landroid/os/Handler;

    invoke-virtual {v13, v14}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->setmHandler(Landroid/os/Handler;)V

    .line 107
    move/from16 v0, p4

    move-object/from16 v1, p0

    iput v0, v1, Lcom/drms/drms_drone/Upload/UploadManager;->request:I

    .line 108
    new-instance v13, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadManagerHandler:Landroid/os/Handler;

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    move/from16 v2, p4

    invoke-direct {v13, v0, v1, v14, v2}, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;-><init>(Landroid/app/Activity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Landroid/os/Handler;I)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->stk500:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    .line 110
    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    .line 111
    .local v4, "arrowOnPaint":Landroid/graphics/Paint;
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f0c0049

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    invoke-virtual {v4, v13}, Landroid/graphics/Paint;->setColor(I)V

    .line 112
    const/high16 v13, 0x41a00000    # 20.0f

    invoke-virtual {v4, v13}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 114
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 115
    .local v3, "arrowOffPaint":Landroid/graphics/Paint;
    const v13, -0x777778

    invoke-virtual {v3, v13}, Landroid/graphics/Paint;->setColor(I)V

    .line 116
    const/high16 v13, 0x41a00000    # 20.0f

    invoke-virtual {v3, v13}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 118
    new-instance v9, Landroid/graphics/Paint;

    invoke-direct {v9}, Landroid/graphics/Paint;-><init>()V

    .line 119
    .local v9, "notConnectedPaint":Landroid/graphics/Paint;
    const/high16 v13, -0x1000000

    invoke-virtual {v9, v13}, Landroid/graphics/Paint;->setColor(I)V

    .line 120
    const/high16 v13, 0x41a00000    # 20.0f

    invoke-virtual {v9, v13}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 122
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03001f

    invoke-static {v13, v14}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v12

    .line 141
    .local v12, "temp":Landroid/graphics/Bitmap;
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03000c

    invoke-static {v13, v14}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v8

    .line 142
    .local v8, "cancel":Landroid/graphics/Bitmap;
    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v13

    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v14

    const/4 v15, 0x1

    invoke-static {v8, v13, v14, v15}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v7

    .line 143
    .local v7, "can":Landroid/graphics/Bitmap;
    new-instance v13, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v13, v7}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->notConnectedDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 145
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03001f

    invoke-static {v13, v14}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v6

    .line 146
    .local v6, "arrowRight":Landroid/graphics/Bitmap;
    invoke-virtual/range {p1 .. p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03002c

    invoke-static {v13, v14}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v5

    .line 148
    .local v5, "arrowRIght_on":Landroid/graphics/Bitmap;
    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v13

    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v14

    const/4 v15, 0x1

    invoke-static {v6, v13, v14, v15}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 149
    .local v10, "off":Landroid/graphics/Bitmap;
    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v13

    invoke-virtual {v12}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v14

    const/4 v15, 0x1

    invoke-static {v5, v13, v14, v15}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v11

    .line 150
    .local v11, "on":Landroid/graphics/Bitmap;
    new-instance v13, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v13, v11}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->arrowOnDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 151
    new-instance v13, Landroid/graphics/drawable/BitmapDrawable;

    invoke-direct {v13, v10}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/graphics/Bitmap;)V

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->arrowOffDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 156
    invoke-direct/range {p0 .. p0}, Lcom/drms/drms_drone/Upload/UploadManager;->makeHexStringFromHexFile()Ljava/lang/String;

    move-result-object v13

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    .line 158
    invoke-direct/range {p0 .. p0}, Lcom/drms/drms_drone/Upload/UploadManager;->requestUploadDialog()V

    .line 160
    const-string v13, "UplaodManager"

    invoke-virtual/range {p2 .. p2}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v14

    invoke-static {v14}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 161
    const-string v13, "UplaodManager"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string v15, "Firm ware \n "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 163
    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->isUploading:Z

    return v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->isUploading:Z

    return p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->init_state:Z

    return v0
.end method

.method static synthetic access$1002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->init_state:Z

    return p1
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->arrowOffDrawable:Landroid/graphics/drawable/BitmapDrawable;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->arrowOnDrawable:Landroid/graphics/drawable/BitmapDrawable;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->notConnectedDrawable:Landroid/graphics/drawable/BitmapDrawable;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/drms/drms_drone/Upload/UploadManager;)B
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-byte v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->orient_command:B

    return v0
.end method

.method static synthetic access$1602(Lcom/drms/drms_drone/Upload/UploadManager;B)B
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # B

    .prologue
    .line 38
    iput-byte p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->orient_command:B

    return p1
.end method

.method static synthetic access$1700(Lcom/drms/drms_drone/Upload/UploadManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/drms/drms_drone/Upload/UploadManager;->display_initializing()V

    return-void
.end method

.method static synthetic access$1800(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/drms/drms_drone/Upload/UploadManager;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/drms/drms_drone/Upload/UploadManager;->displayStateOfUpload()V

    return-void
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stk500:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    return-object v0
.end method

.method static synthetic access$202(Lcom/drms/drms_drone/Upload/UploadManager;Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stk500:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    return-object p1
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->startUpload:Z

    return v0
.end method

.method static synthetic access$302(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->startUpload:Z

    return p1
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/support/v7/app/AlertDialog;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->dialog:Landroid/support/v7/app/AlertDialog;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-object v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadManagerHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/drms/drms_drone/Upload/UploadManager;->requestUpload()Z

    move-result v0

    return v0
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadSuccess:Z

    return v0
.end method

.method static synthetic access$702(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadSuccess:Z

    return p1
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Upload/UploadManager;)I
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stateOnIndex:I

    return v0
.end method

.method static synthetic access$802(Lcom/drms/drms_drone/Upload/UploadManager;I)I
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # I

    .prologue
    .line 38
    iput p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stateOnIndex:I

    return p1
.end method

.method static synthetic access$808(Lcom/drms/drms_drone/Upload/UploadManager;)I
    .locals 2
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stateOnIndex:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->stateOnIndex:I

    return v0
.end method

.method static synthetic access$900(Lcom/drms/drms_drone/Upload/UploadManager;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;

    .prologue
    .line 38
    iget-boolean v0, p0, Lcom/drms/drms_drone/Upload/UploadManager;->isInitializing:Z

    return v0
.end method

.method static synthetic access$902(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Upload/UploadManager;
    .param p1, "x1"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/drms/drms_drone/Upload/UploadManager;->isInitializing:Z

    return p1
.end method

.method private displayStateOfUpload()V
    .locals 2

    .prologue
    .line 316
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager$6;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Upload/UploadManager$6;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 329
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 330
    return-void
.end method

.method private display_initializing()V
    .locals 2

    .prologue
    .line 334
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager$7;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Upload/UploadManager$7;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 358
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 359
    return-void
.end method

.method private makeHexStringFromHexFile()Ljava/lang/String;
    .locals 8

    .prologue
    .line 536
    const/4 v3, 0x0

    .line 537
    .local v3, "inputStream":Ljava/io/InputStream;
    iget v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->request:I

    packed-switch v6, :pswitch_data_0

    .line 564
    :goto_0
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 565
    .local v1, "buffer":Ljava/lang/StringBuffer;
    const/16 v6, 0x400

    new-array v0, v6, [B

    .line 568
    .local v0, "b":[B
    :goto_1
    :try_start_0
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v4

    .local v4, "n":I
    const/4 v6, -0x1

    if-eq v4, v6, :cond_0

    .line 569
    new-instance v6, Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {v6, v0, v7, v4}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v1, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 571
    .end local v4    # "n":I
    :catch_0
    move-exception v6

    .line 573
    :cond_0
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    .line 575
    .local v5, "str":Ljava/lang/String;
    const-string v6, ":"

    const-string v7, "3A"

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 576
    .local v2, "hexData_temp":Ljava/lang/String;
    const-string v6, "line.separator"

    invoke-static {v6}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v2, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 577
    const-string v6, "\\p{Space}"

    const-string v7, ""

    invoke-virtual {v2, v6, v7}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 579
    return-object v2

    .line 539
    .end local v0    # "b":[B
    .end local v1    # "buffer":Ljava/lang/StringBuffer;
    .end local v2    # "hexData_temp":Ljava/lang/String;
    .end local v5    # "str":Ljava/lang/String;
    :pswitch_0
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f070008

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 540
    goto :goto_0

    .line 543
    :pswitch_1
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f070009

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 544
    goto :goto_0

    .line 547
    :pswitch_2
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f07000a

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 548
    goto :goto_0

    .line 551
    :pswitch_3
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f070005

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 552
    goto :goto_0

    .line 555
    :pswitch_4
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f070006

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 556
    goto/16 :goto_0

    .line 559
    :pswitch_5
    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f070007

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    goto/16 :goto_0

    .line 537
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method private requestCommand([Ljava/lang/Character;)[B
    .locals 3
    .param p1, "command"    # [Ljava/lang/Character;

    .prologue
    .line 585
    array-length v2, p1

    new-array v0, v2, [B

    .line 587
    .local v0, "data_set":[B
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_0

    .line 588
    aget-object v2, p1, v1

    invoke-virtual {v2}, Ljava/lang/Character;->charValue()C

    move-result v2

    and-int/lit16 v2, v2, 0xff

    int-to-byte v2, v2

    aput-byte v2, v0, v1

    .line 587
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 594
    :cond_0
    return-object v0
.end method

.method private requestUpload()Z
    .locals 9

    .prologue
    const/16 v8, 0xff

    .line 254
    const/4 v3, 0x1

    .line 255
    .local v3, "success":Z
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    if-eqz v5, :cond_3

    .line 256
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;->getState()I

    move-result v5

    const/4 v6, 0x4

    if-ne v5, v6, :cond_1

    .line 258
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    const-string v6, "\ub9ac\uc14b \ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc138\uc694."

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    const-string v5, "UplaodManager"

    const-string v6, "make stk500 instance"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 266
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    new-array v1, v5, [B

    .line 267
    .local v1, "binaryFile":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    if-ge v2, v5, :cond_0

    .line 268
    div-int/lit8 v5, v2, 0x2

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "0x"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/drms/drms_drone/Upload/UploadManager;->hexData:Ljava/lang/String;

    add-int/lit8 v8, v2, 0x2

    invoke-virtual {v7, v2, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Integer;->decode(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->byteValue()B

    move-result v6

    aput-byte v6, v1, v5

    .line 267
    add-int/lit8 v2, v2, 0x2

    goto :goto_0

    .line 270
    :cond_0
    const/16 v0, 0x100

    .line 273
    .local v0, "UnitOfByte":I
    new-instance v5, Ljava/lang/Thread;

    new-instance v6, Lcom/drms/drms_drone/Upload/UploadManager$5;

    invoke-direct {v6, p0, v1}, Lcom/drms/drms_drone/Upload/UploadManager$5;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;[B)V

    invoke-direct {v5, v6}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 290
    invoke-virtual {v5}, Ljava/lang/Thread;->start()V

    .end local v0    # "UnitOfByte":I
    .end local v1    # "binaryFile":[B
    .end local v2    # "i":I
    :goto_1
    move v4, v3

    .line 311
    .end local v3    # "success":Z
    .local v4, "success":I
    :goto_2
    return v4

    .line 293
    .end local v4    # "success":I
    .restart local v3    # "success":Z
    :cond_1
    const/4 v3, 0x0

    .line 294
    const-string v5, "UplaodManager"

    const-string v6, "bluetooth communication is not connected"

    invoke-static {v5, v6}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 295
    const/4 v5, 0x0

    iput-boolean v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->isUploading:Z

    .line 296
    const/4 v2, 0x0

    .restart local v2    # "i":I
    :goto_3
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    array-length v5, v5

    if-ge v2, v5, :cond_2

    .line 297
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    aget-object v5, v5, v2

    iget-object v6, p0, Lcom/drms/drms_drone/Upload/UploadManager;->notConnectedDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 296
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 299
    :cond_2
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    const/16 v6, 0x3d

    const/16 v7, 0x5f

    invoke-static {v8, v8, v6, v7}, Landroid/graphics/Color;->argb(IIII)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setTextColor(I)V

    .line 300
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    const-string v6, "\ube14\ub8e8\ud22c\uc2a4 \uc5f0\uacb0\uc774 \ub04a\uc5b4\uc84c\uc2b5\ub2c8\ub2e4."

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 302
    const-wide/16 v6, 0x3e8

    :try_start_0
    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 304
    :goto_4
    iget-object v5, p0, Lcom/drms/drms_drone/Upload/UploadManager;->dialog:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v5}, Landroid/support/v7/app/AlertDialog;->dismiss()V

    move v4, v3

    .line 305
    .restart local v4    # "success":I
    goto :goto_2

    .line 309
    .end local v2    # "i":I
    .end local v4    # "success":I
    :cond_3
    const/4 v3, 0x0

    goto :goto_1

    .line 303
    .restart local v2    # "i":I
    :catch_0
    move-exception v5

    goto :goto_4
.end method

.method private requestUploadDialog()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, -0x2

    .line 166
    new-instance v2, Landroid/support/v7/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-direct {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    .line 167
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x1002

    invoke-virtual {v2, v3}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 173
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    const v3, 0x7f04001f

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/support/constraint/ConstraintLayout;

    .line 174
    .local v1, "upload_view":Landroid/support/constraint/ConstraintLayout;
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {v2, v6}, Landroid/support/v7/app/AlertDialog$Builder;->setCancelable(Z)Landroid/support/v7/app/AlertDialog$Builder;

    .line 175
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    const-string v3, "\ub2eb\uae30"

    new-instance v4, Lcom/drms/drms_drone/Upload/UploadManager$1;

    invoke-direct {v4, p0}, Lcom/drms/drms_drone/Upload/UploadManager$1;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    invoke-virtual {v2, v3, v4}, Landroid/support/v7/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 188
    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    const v2, 0x7f0d006f

    invoke-virtual {v1, v2}, Landroid/support/constraint/ConstraintLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    aput-object v2, v3, v6

    .line 189
    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    const/4 v4, 0x1

    const v2, 0x7f0d006e

    invoke-virtual {v1, v2}, Landroid/support/constraint/ConstraintLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    aput-object v2, v3, v4

    .line 190
    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    const/4 v4, 0x2

    const v2, 0x7f0d0072

    invoke-virtual {v1, v2}, Landroid/support/constraint/ConstraintLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    aput-object v2, v3, v4

    .line 191
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    array-length v2, v2

    if-ge v0, v2, :cond_0

    .line 192
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->state:[Landroid/widget/ImageView;

    aget-object v2, v2, v0

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->notConnectedDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 191
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 194
    :cond_0
    const v2, 0x7f0d0071

    invoke-virtual {v1, v2}, Landroid/support/constraint/ConstraintLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    .line 195
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->information:Landroid/widget/TextView;

    const-string v3, "\uc5c5\ub85c\ub4dc\ub97c \uc900\ube44 \uc911 \uc785\ub2c8\ub2e4."

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    const v2, 0x7f0d0073

    invoke-virtual {v1, v2}, Landroid/support/constraint/ConstraintLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progresslayout:Landroid/widget/LinearLayout;

    .line 198
    new-instance v2, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->mActivity:Landroid/app/Activity;

    invoke-direct {v2, p0, v3}, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;Landroid/content/Context;)V

    iput-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    .line 199
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v3, v5, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3}, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 200
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progresslayout:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 202
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->progressBar:Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;

    invoke-virtual {v2}, Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;->invalidate()V

    .line 204
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    new-instance v3, Lcom/drms/drms_drone/Upload/UploadManager$2;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Upload/UploadManager$2;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    invoke-virtual {v2, v3}, Landroid/support/v7/app/AlertDialog$Builder;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 218
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {v2, v1}, Landroid/support/v7/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/support/v7/app/AlertDialog$Builder;

    .line 219
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->upload_dialog:Landroid/support/v7/app/AlertDialog$Builder;

    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog$Builder;->create()Landroid/support/v7/app/AlertDialog;

    move-result-object v2

    iput-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->dialog:Landroid/support/v7/app/AlertDialog;

    .line 221
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->dialog:Landroid/support/v7/app/AlertDialog;

    invoke-virtual {v2}, Landroid/support/v7/app/AlertDialog;->show()V

    .line 222
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/drms/drms_drone/Upload/UploadManager$3;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Upload/UploadManager$3;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 242
    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    .line 244
    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager;->uploadManagerHandler:Landroid/os/Handler;

    new-instance v3, Lcom/drms/drms_drone/Upload/UploadManager$4;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Upload/UploadManager$4;-><init>(Lcom/drms/drms_drone/Upload/UploadManager;)V

    const-wide/16 v4, 0x5dc

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 250
    return-void
.end method
