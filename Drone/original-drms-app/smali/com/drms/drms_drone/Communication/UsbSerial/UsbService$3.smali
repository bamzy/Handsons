.class Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;
.super Ljava/lang/Object;
.source "UsbService.java"

# interfaces
.implements Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;


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
    .line 122
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDSRChanged(Z)V
    .locals 4
    .param p1, "state"    # Z

    .prologue
    .line 125
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/os/Handler;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 126
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$3;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/os/Handler;

    move-result-object v0

    const/16 v1, 0xb

    const/4 v2, 0x2

    const/4 v3, -0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->obtainMessage(III)Landroid/os/Message;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 127
    :cond_0
    return-void
.end method
