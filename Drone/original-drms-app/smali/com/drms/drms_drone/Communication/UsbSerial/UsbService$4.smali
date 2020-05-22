.class Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;
.super Landroid/content/BroadcastReceiver;
.source "UsbService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    const/4 v4, 0x0

    .line 136
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.android.example.USB_PERMISSION"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 137
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "permission"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 138
    .local v0, "granted":Z
    if-eqz v0, :cond_1

    .line 140
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.felhr.usbservice.USB_PERMISSION_GRANTED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 141
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p1, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 142
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$800(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbManager;

    move-result-object v3

    iget-object v4, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbDevice;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/hardware/usb/UsbManager;->openDevice(Landroid/hardware/usb/UsbDevice;)Landroid/hardware/usb/UsbDeviceConnection;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$602(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Landroid/hardware/usb/UsbDeviceConnection;)Landroid/hardware/usb/UsbDeviceConnection;

    .line 143
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    const/4 v3, 0x1

    invoke-static {v2, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 144
    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;

    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    const/4 v4, 0x0

    invoke-direct {v2, v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;)V

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->start()V

    .line 166
    .end local v0    # "granted":Z
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 148
    .restart local v0    # "granted":Z
    :cond_1
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 149
    .restart local v1    # "intent":Landroid/content/Intent;
    invoke-virtual {p1, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_0

    .line 151
    .end local v0    # "granted":Z
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "android.hardware.usb.action.USB_DEVICE_ATTACHED"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 152
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 153
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1100(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    goto :goto_0

    .line 154
    :cond_3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "android.hardware.usb.action.USB_DEVICE_DETACHED"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 156
    new-instance v1, Landroid/content/Intent;

    const-string v2, "com.felhr.usbservice.USB_DISCONNECTED"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 157
    .restart local v1    # "intent":Landroid/content/Intent;
    invoke-virtual {p1, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 158
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 159
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->close()V

    .line 161
    :cond_4
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 162
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 163
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 164
    iget-object v2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$4;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2, v4}, Lcom/drms/drms_drone/MultiData;->setControllerConnected(Z)V

    goto :goto_0
.end method
