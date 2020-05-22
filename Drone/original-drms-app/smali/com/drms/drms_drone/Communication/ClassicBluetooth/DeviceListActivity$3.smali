.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;
.super Ljava/lang/Object;
.source "DeviceListActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;
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
    .line 184
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
    .param p2, "v"    # Landroid/view/View;
    .param p3, "arg2"    # I
    .param p4, "arg3"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 187
    .local p1, "av":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$100(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/bluetooth/BluetoothAdapter;

    move-result-object v3

    invoke-virtual {v3}, Landroid/bluetooth/BluetoothAdapter;->cancelDiscovery()Z

    .line 191
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v3

    invoke-interface {v3, p3}, Landroid/widget/Adapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    invoke-virtual {v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;->getData()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    aget-object v2, v3, v4

    .line 192
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getAdapter()Landroid/widget/Adapter;

    move-result-object v3

    invoke-interface {v3, p3}, Landroid/widget/Adapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    invoke-virtual {v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;->getData()[Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aget-object v0, v3, v4

    .line 197
    .local v0, "address":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 198
    .local v1, "intent":Landroid/content/Intent;
    sget-object v3, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_ADDRESS:Ljava/lang/String;

    invoke-virtual {v1, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 199
    sget-object v3, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->EXTRA_DEVICE_NAME:Ljava/lang/String;

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 202
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    const/4 v4, -0x1

    invoke-virtual {v3, v4, v1}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setResult(ILandroid/content/Intent;)V

    .line 203
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$3;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-virtual {v3}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->finish()V

    .line 205
    return-void
.end method
