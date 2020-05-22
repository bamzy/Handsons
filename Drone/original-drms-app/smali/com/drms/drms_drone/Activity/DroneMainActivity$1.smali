.class Lcom/drms/drms_drone/Activity/DroneMainActivity$1;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;->implementationDrawerList()V
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
    .line 288
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 10
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "l"    # J
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
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const v9, 0x7f05000c

    const v8, 0x7f05000b

    const/4 v7, 0x0

    .line 291
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 292
    packed-switch p3, :pswitch_data_0

    .line 340
    :goto_0
    return-void

    .line 294
    :pswitch_0
    invoke-static {}, Landroid/bluetooth/BluetoothAdapter;->getDefaultAdapter()Landroid/bluetooth/BluetoothAdapter;

    move-result-object v0

    .line 295
    .local v0, "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    if-nez v0, :cond_0

    .line 296
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "bluetooth is not available"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 299
    :cond_0
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "Bluetooth is available"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 300
    invoke-virtual {v0}, Landroid/bluetooth/BluetoothAdapter;->isEnabled()Z

    move-result v4

    if-nez v4, :cond_1

    .line 301
    new-instance v1, Landroid/content/Intent;

    const-string v4, "android.bluetooth.adapter.action.REQUEST_ENABLE"

    invoke-direct {v1, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 302
    .local v1, "btEnabledIntent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v5, 0x2

    invoke-virtual {v4, v1, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 305
    .end local v1    # "btEnabledIntent":Landroid/content/Intent;
    :cond_1
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request_finish_service"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 306
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v5, ""

    invoke-static {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$202(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 307
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v5, ""

    invoke-static {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$302(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 308
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v4

    const-string v5, ""

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Lcom/drms/drms_drone/FileManagement/FileManagement;->writeBtAddressOnFile(Ljava/lang/String;Ljava/lang/String;)Z

    .line 310
    new-instance v3, Landroid/content/Intent;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-class v5, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 311
    .local v3, "scanIntent":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Service/BTService;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/drms/drms_drone/Service/BTService;->setisDiscovered(Z)V

    .line 312
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v5, 0x1

    invoke-virtual {v4, v3, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 313
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v4, v8, v9}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    goto :goto_0

    .line 320
    .end local v0    # "btAdapter":Landroid/bluetooth/BluetoothAdapter;
    .end local v3    # "scanIntent":Landroid/content/Intent;
    :pswitch_1
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f030004

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 321
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, " Disconnected..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 322
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 323
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$400(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v4

    const-string v5, ""

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Lcom/drms/drms_drone/FileManagement/FileManagement;->writeBtAddressOnFile(Ljava/lang/String;Ljava/lang/String;)Z

    .line 324
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "initialize Bluetooth Device"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 325
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$900(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "No device"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 326
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v5, ""

    invoke-static {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$302(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 327
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-string v5, ""

    invoke-static {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$202(Lcom/drms/drms_drone/Activity/DroneMainActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 328
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request_finish_service"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 332
    :pswitch_2
    new-instance v2, Landroid/content/Intent;

    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const-class v5, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 333
    .local v2, "programDrone":Landroid/content/Intent;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    const-string v6, "request_program"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 334
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v4

    const v5, 0x800003

    invoke-virtual {v4, v5}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    .line 335
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/16 v5, 0x8

    invoke-virtual {v4, v2, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 336
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v4, v8, v9}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->overridePendingTransition(II)V

    goto/16 :goto_0

    .line 292
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
