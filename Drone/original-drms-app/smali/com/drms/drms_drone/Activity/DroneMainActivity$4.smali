.class Lcom/drms/drms_drone/Activity/DroneMainActivity$4;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;->requestSettingBtDialog()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 370
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 6
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;
    .param p2, "i"    # I

    .prologue
    .line 373
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 374
    .local v0, "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    if-nez v0, :cond_0

    .line 375
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "bluetooth is not available"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 390
    :goto_0
    return-void

    .line 378
    :cond_0
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "Bluetooth is available"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 379
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v3

    if-nez v3, :cond_1

    .line 380
    new-instance v1, Landroid/content/Intent;

    const-string v3, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 381
    .local v1, "btEnabledIntent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v4, 0x2

    invoke-virtual {v3, v1, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 384
    .end local v1    # "btEnabledIntent":Landroid/content/Intent;
    :cond_1
    new-instance v2, Landroid/content/Intent;

    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-class v4, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 385
    .local v2, "scanIntent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v4, 0x1

    invoke-virtual {v3, v2, v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 386
    iget-object v3, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$4;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const v4, 0x7f05000b

    const v5, 0x7f05000c

    invoke-virtual {v3, v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method
