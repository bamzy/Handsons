.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;
.super Landroid/content/BroadcastReceiver;
.source "DeviceListActivity.java"


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
    .line 210
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 16
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 213
    invoke-virtual/range {p2 .. p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    .line 216
    .local v1, "action":Ljava/lang/String;
    const-string v11, "android.bluetooth.device.action.FOUND"

    invoke-virtual {v11, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 218
    const-string v11, "android.bluetooth.device.extra.DEVICE"

    move-object/from16 v0, p2

    invoke-virtual {v0, v11}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    check-cast v5, Landroid/bluetooth/BluetoothDevice;

    .line 220
    .local v5, "device":Landroid/bluetooth/BluetoothDevice;
    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getBondState()I

    move-result v11

    const/16 v12, 0xc

    if-eq v11, v12, :cond_3

    .line 221
    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v7

    .line 222
    .local v7, "name":Ljava/lang/String;
    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v2

    .line 225
    .local v2, "address":Ljava/lang/String;
    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v11

    if-eqz v11, :cond_2

    .line 226
    const-string v11, "DeviceListActivity"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "Discoverd Device : "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " \n address : "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 227
    const/4 v4, 0x0

    .line 229
    .local v4, "alreadyDiscovered":Z
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getCount()I

    move-result v11

    if-eqz v11, :cond_1

    .line 230
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getCount()I

    move-result v11

    if-ge v6, v11, :cond_1

    .line 231
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11, v6}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getItem(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    .line 232
    .local v10, "temp":Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;
    invoke-virtual {v10}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;->getData()[Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    aget-object v8, v11, v12

    .line 233
    .local v8, "name_temp":Ljava/lang/String;
    invoke-virtual {v10}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;->getData()[Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x1

    aget-object v3, v11, v12

    .line 234
    .local v3, "address_temp":Ljava/lang/String;
    const-string v11, "DeviceListActivity"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "nameTemp : "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "\naddressTemp : "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 235
    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_0

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 236
    const/4 v4, 0x1

    .line 230
    :cond_0
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 240
    .end local v3    # "address_temp":Ljava/lang/String;
    .end local v6    # "i":I
    .end local v8    # "name_temp":Ljava/lang/String;
    .end local v10    # "temp":Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;
    :cond_1
    if-eqz v4, :cond_4

    .line 241
    const-string v11, "DeviceListActivity"

    const-string v12, "this device is already discovered"

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 255
    .end local v4    # "alreadyDiscovered":Z
    :cond_2
    :goto_1
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/ListView;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v12}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 256
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/ListView;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v12}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$500(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 257
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$400(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/ListView;

    move-result-object v11

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v12}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$500(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Landroid/widget/AdapterView$OnItemClickListener;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 271
    .end local v2    # "address":Ljava/lang/String;
    .end local v5    # "device":Landroid/bluetooth/BluetoothDevice;
    .end local v7    # "name":Ljava/lang/String;
    :cond_3
    :goto_2
    return-void

    .line 244
    .restart local v2    # "address":Ljava/lang/String;
    .restart local v4    # "alreadyDiscovered":Z
    .restart local v5    # "device":Landroid/bluetooth/BluetoothDevice;
    .restart local v7    # "name":Ljava/lang/String;
    :cond_4
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getCount()I

    move-result v11

    if-eqz v11, :cond_5

    .line 245
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getItem(I)Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    .line 246
    .restart local v10    # "temp":Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;
    invoke-virtual {v10}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;->getData()[Ljava/lang/String;

    move-result-object v11

    const/4 v12, 0x0

    aget-object v11, v11, v12

    const-string v12, "No device"

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_5

    .line 247
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->removeItem()V

    .line 250
    .end local v10    # "temp":Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;
    :cond_5
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    new-instance v12, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-virtual {v13}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03000f

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v13

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v5}, Landroid/bluetooth/BluetoothDevice;->getAddress()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v12, v13, v14, v15}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v11, v12}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;)V

    goto/16 :goto_1

    .line 261
    .end local v2    # "address":Ljava/lang/String;
    .end local v4    # "alreadyDiscovered":Z
    .end local v5    # "device":Landroid/bluetooth/BluetoothDevice;
    .end local v7    # "name":Ljava/lang/String;
    :cond_6
    const-string v11, "android.bluetooth.adapter.action.DISCOVERY_FINISHED"

    invoke-virtual {v11, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_3

    .line 262
    const-string v11, "DeviceListActivity"

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string v13, "finished "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 263
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$000(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    .line 264
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setProgressBarIndeterminateVisibility(Z)V

    .line 265
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    const v12, 0x7f080028

    invoke-virtual {v11, v12}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->setTitle(I)V

    .line 266
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    invoke-virtual {v11}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->getCount()I

    move-result v11

    if-nez v11, :cond_3

    .line 267
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-virtual {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f080024

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v11

    invoke-interface {v11}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v9

    .line 268
    .local v9, "noDevices":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v11}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$300(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;

    move-result-object v11

    new-instance v12, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$4;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-virtual {v13}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    const v14, 0x7f03000c

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v13

    const-string v14, "No device"

    const-string v15, ""

    invoke-direct {v12, v13, v14, v15}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;-><init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v11, v12}, Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/CustomAdapter2;->addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdatper2/Custom2_Item;)V

    goto/16 :goto_2
.end method
