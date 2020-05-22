.class public Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
.super Landroid/app/Service;
.source "UsbService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;,
        Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;
    }
.end annotation


# static fields
.field public static final ACTION_CDC_DRIVER_NOT_WORKING:Ljava/lang/String; = "com.felhr.connectivityservices.ACTION_CDC_DRIVER_NOT_WORKING"

.field public static final ACTION_NO_USB:Ljava/lang/String; = "com.felhr.usbservice.NO_USB"

.field public static final ACTION_USB_ATTACHED:Ljava/lang/String; = "android.hardware.usb.action.USB_DEVICE_ATTACHED"

.field public static final ACTION_USB_DETACHED:Ljava/lang/String; = "android.hardware.usb.action.USB_DEVICE_DETACHED"

.field public static final ACTION_USB_DEVICE_NOT_WORKING:Ljava/lang/String; = "com.felhr.connectivityservices.ACTION_USB_DEVICE_NOT_WORKING"

.field public static final ACTION_USB_DISCONNECTED:Ljava/lang/String; = "com.felhr.usbservice.USB_DISCONNECTED"

.field public static final ACTION_USB_NOT_SUPPORTED:Ljava/lang/String; = "com.felhr.usbservice.USB_NOT_SUPPORTED"

.field private static final ACTION_USB_PERMISSION:Ljava/lang/String; = "com.android.example.USB_PERMISSION"

.field public static final ACTION_USB_PERMISSION_GRANTED:Ljava/lang/String; = "com.felhr.usbservice.USB_PERMISSION_GRANTED"

.field public static final ACTION_USB_PERMISSION_NOT_GRANTED:Ljava/lang/String; = "com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED"

.field public static final ACTION_USB_READY:Ljava/lang/String; = "com.felhr.connectivityservices.USB_READY"

.field private static final BAUD_RATE:I = 0xe100

.field public static final CONNECTED_CONTROLLER:Ljava/lang/String; = "com.drms.drms_drone.CONNECTED_CONTROLLER"

.field public static final CTS_CHANGE:I = 0x1

.field public static final DSR_CHANGE:I = 0x2

.field public static final MESSAGE_FROM_SERIAL_PORT:I = 0x0

.field public static final MESSAGE_FROM_USBSERVERVICE:I = 0xb

.field public static SERVICE_CONNECTED:Z = false

.field private static final TAG:Ljava/lang/String; = "UsbService"


# instance fields
.field private binder:Landroid/os/IBinder;

.field private connected:Z

.field private connectedRequested:Z

.field private connection:Landroid/hardware/usb/UsbDeviceConnection;

.field private context:Landroid/content/Context;

.field private ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

.field private device:Landroid/hardware/usb/UsbDevice;

.field private drsController:Lcom/drms/drms_drone/DrsController/DrsControllerManager;

.field private dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

.field private mCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;

.field private mHandler:Landroid/os/Handler;

.field private multiData:Lcom/drms/drms_drone/MultiData;

.field private serialPort:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

.field private serialPortConnected:Z

.field private usbManager:Landroid/hardware/usb/UsbManager;

.field private final usbReceiver:Landroid/content/BroadcastReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    sput-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->SERVICE_CONNECTED:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 27
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 51
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->binder:Landroid/os/IBinder;

    .line 63
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connected:Z

    .line 64
    iput-boolean v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connectedRequested:Z

    .line 73
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->mCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;

    .line 111
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$2;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$2;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    .line 122
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    .line 133
    new-instance v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbReceiver:Landroid/content/BroadcastReceiver;

    return-void
.end method

.method static synthetic access$000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connected:Z

    return v0
.end method

.method static synthetic access$002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connected:Z

    return p1
.end method

.method static synthetic access$100(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connectedRequested:Z

    return v0
.end method

.method static synthetic access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPortConnected:Z

    return v0
.end method

.method static synthetic access$1002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPortConnected:Z

    return p1
.end method

.method static synthetic access$102(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p1, "x1"    # Z

    .prologue
    .line 27
    iput-boolean p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connectedRequested:Z

    return p1
.end method

.method static synthetic access$1100(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->findSerialPortDevice()V

    return-void
.end method

.method static synthetic access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPort:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    return-object v0
.end method

.method static synthetic access$1202(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p1, "x1"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPort:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    return-object p1
.end method

.method static synthetic access$1300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->mCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->ctsCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->dsrCallback:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    return-object v0
.end method

.method static synthetic access$200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/MultiData;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->multiData:Lcom/drms/drms_drone/MultiData;

    return-object v0
.end method

.method static synthetic access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$500(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/DrsController/DrsControllerManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->drsController:Lcom/drms/drms_drone/DrsController/DrsControllerManager;

    return-object v0
.end method

.method static synthetic access$600(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbDeviceConnection;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    return-object v0
.end method

.method static synthetic access$602(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Landroid/hardware/usb/UsbDeviceConnection;)Landroid/hardware/usb/UsbDeviceConnection;
    .locals 0
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p1, "x1"    # Landroid/hardware/usb/UsbDeviceConnection;

    .prologue
    .line 27
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    return-object p1
.end method

.method static synthetic access$700(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbDevice;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    return-object v0
.end method

.method static synthetic access$800(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbManager;
    .locals 1
    .param p0, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbManager:Landroid/hardware/usb/UsbManager;

    return-object v0
.end method

.method private findSerialPortDevice()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 221
    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbManager:Landroid/hardware/usb/UsbManager;

    invoke-virtual {v6}, Landroid/hardware/usb/UsbManager;->getDeviceList()Ljava/util/HashMap;

    move-result-object v5

    .line 222
    .local v5, "usbDevices":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Landroid/hardware/usb/UsbDevice;>;"
    invoke-virtual {v5}, Ljava/util/HashMap;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_4

    .line 223
    const/4 v4, 0x1

    .line 224
    .local v4, "keep":Z
    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 225
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/hardware/usb/UsbDevice;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/hardware/usb/UsbDevice;

    iput-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    .line 226
    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    invoke-virtual {v6}, Landroid/hardware/usb/UsbDevice;->getVendorId()I

    move-result v1

    .line 227
    .local v1, "deviceVID":I
    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    invoke-virtual {v6}, Landroid/hardware/usb/UsbDevice;->getProductId()I

    move-result v0

    .line 229
    .local v0, "devicePID":I
    const/16 v6, 0x1d6b

    if-eq v1, v6, :cond_3

    const/4 v6, 0x1

    if-eq v0, v6, :cond_3

    const/4 v6, 0x2

    if-eq v0, v6, :cond_3

    const/4 v6, 0x3

    if-eq v0, v6, :cond_3

    .line 231
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->requestUserPermission()V

    .line 232
    const/4 v4, 0x0

    .line 238
    :goto_0
    if-nez v4, :cond_0

    .line 241
    .end local v0    # "devicePID":I
    .end local v1    # "deviceVID":I
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/hardware/usb/UsbDevice;>;"
    :cond_1
    if-nez v4, :cond_2

    .line 243
    new-instance v3, Landroid/content/Intent;

    const-string v6, "com.felhr.usbservice.NO_USB"

    invoke-direct {v3, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 244
    .local v3, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->sendBroadcast(Landroid/content/Intent;)V

    .line 251
    .end local v3    # "intent":Landroid/content/Intent;
    .end local v4    # "keep":Z
    :cond_2
    :goto_1
    return-void

    .line 234
    .restart local v0    # "devicePID":I
    .restart local v1    # "deviceVID":I
    .restart local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/hardware/usb/UsbDevice;>;"
    .restart local v4    # "keep":Z
    :cond_3
    iput-object v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->connection:Landroid/hardware/usb/UsbDeviceConnection;

    .line 235
    iput-object v8, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    goto :goto_0

    .line 248
    .end local v0    # "devicePID":I
    .end local v1    # "deviceVID":I
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/hardware/usb/UsbDevice;>;"
    .end local v4    # "keep":Z
    :cond_4
    new-instance v3, Landroid/content/Intent;

    const-string v6, "com.felhr.usbservice.NO_USB"

    invoke-direct {v3, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 249
    .restart local v3    # "intent":Landroid/content/Intent;
    invoke-virtual {p0, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method private requestUserPermission()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 265
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.android.example.USB_PERMISSION"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v3, v1, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    .line 266
    .local v0, "mPendingIntent":Landroid/app/PendingIntent;
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbManager:Landroid/hardware/usb/UsbManager;

    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->device:Landroid/hardware/usb/UsbDevice;

    invoke-virtual {v1, v2, v0}, Landroid/hardware/usb/UsbManager;->requestPermission(Landroid/hardware/usb/UsbDevice;Landroid/app/PendingIntent;)V

    .line 267
    return-void
.end method

.method private setFilter()V
    .locals 2

    .prologue
    .line 254
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 255
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "com.android.example.USB_PERMISSION"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 256
    const-string v1, "android.hardware.usb.action.USB_DEVICE_DETACHED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 257
    const-string v1, "android.hardware.usb.action.USB_DEVICE_ATTACHED"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 258
    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 259
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 191
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->binder:Landroid/os/IBinder;

    return-object v0
.end method

.method public onCreate()V
    .locals 1

    .prologue
    .line 175
    iput-object p0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->context:Landroid/content/Context;

    .line 176
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPortConnected:Z

    .line 177
    const/4 v0, 0x1

    sput-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->SERVICE_CONNECTED:Z

    .line 178
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->setFilter()V

    .line 179
    const-string v0, "usb"

    invoke-virtual {p0, v0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/hardware/usb/UsbManager;

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->usbManager:Landroid/hardware/usb/UsbManager;

    .line 180
    invoke-direct {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->findSerialPortDevice()V

    .line 181
    invoke-virtual {p0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/drms/drms_drone/MultiData;

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->multiData:Lcom/drms/drms_drone/MultiData;

    .line 182
    new-instance v0, Lcom/drms/drms_drone/DrsController/DrsControllerManager;

    invoke-direct {v0, p0}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;-><init>(Landroid/app/Service;)V

    iput-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->drsController:Lcom/drms/drms_drone/DrsController/DrsControllerManager;

    .line 183
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 201
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 202
    const/4 v0, 0x0

    sput-boolean v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->SERVICE_CONNECTED:Z

    .line 203
    return-void
.end method

.method public onStartCommand(Landroid/content/Intent;II)I
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "flags"    # I
    .param p3, "startId"    # I

    .prologue
    .line 196
    const/4 v0, 0x2

    return v0
.end method

.method public setHandler(Landroid/os/Handler;)V
    .locals 0
    .param p1, "mHandler"    # Landroid/os/Handler;

    .prologue
    .line 216
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->mHandler:Landroid/os/Handler;

    .line 217
    return-void
.end method

.method public write([B)V
    .locals 1
    .param p1, "data"    # [B

    .prologue
    .line 209
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPort:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    if-eqz v0, :cond_0

    .line 211
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->serialPort:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    invoke-virtual {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->write([B)V

    .line 213
    :cond_0
    return-void
.end method
