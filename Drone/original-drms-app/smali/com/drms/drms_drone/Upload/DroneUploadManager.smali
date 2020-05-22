.class public Lcom/drms/drms_drone/Upload/DroneUploadManager;
.super Ljava/lang/Object;
.source "DroneUploadManager.java"


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;)V
    .locals 0
    .param p1, "mActivity"    # Landroid/app/Activity;
    .param p2, "mBluetoothService"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p2, p0, Lcom/drms/drms_drone/Upload/DroneUploadManager;->mBluetoothService:Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    .line 19
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/DroneUploadManager;->mActivity:Landroid/app/Activity;

    .line 21
    return-void
.end method
