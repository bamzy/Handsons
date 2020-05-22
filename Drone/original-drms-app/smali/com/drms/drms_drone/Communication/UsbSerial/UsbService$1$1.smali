.class Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;
.super Ljava/lang/Object;
.source "UsbService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->onReceivedData([B)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

.field final synthetic val$datain:[B


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;[B)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;->this$1:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

    iput-object p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;->val$datain:[B

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;->this$1:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$500(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/DrsController/DrsControllerManager;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;->val$datain:[B

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/DrsController/DrsControllerManager;->processControllerData([B)Z

    .line 96
    return-void
.end method
