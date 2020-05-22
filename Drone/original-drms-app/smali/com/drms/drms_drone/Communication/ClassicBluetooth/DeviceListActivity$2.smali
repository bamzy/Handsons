.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;
.super Ljava/lang/Object;
.source "DeviceListActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->doDiscovery()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 171
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$100(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->startDiscovery()Z

    .line 172
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$208(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)I

    .line 173
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$200(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 174
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v0

    invoke-virtual {v0}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->removeItem()V

    .line 175
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$2;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$202(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;I)I

    .line 177
    :cond_0
    return-void
.end method
