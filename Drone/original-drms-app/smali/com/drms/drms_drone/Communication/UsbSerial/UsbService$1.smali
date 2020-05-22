.class Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;
.super Ljava/lang/Object;
.source "UsbService.java"

# interfaces
.implements Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;


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
    .line 73
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceivedData([B)V
    .locals 6
    .param p1, "arg0"    # [B

    .prologue
    .line 77
    :try_start_0
    new-instance v0, Ljava/lang/String;

    const-string v3, "UTF-8"

    invoke-direct {v0, p1, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    .line 78
    .local v0, "data":Ljava/lang/String;
    const-string v3, "HELLO"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 79
    const-string v3, "UsbService"

    const-string v4, "Connected"

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 80
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 81
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    const/4 v4, 0x0

    invoke-static {v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$102(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 82
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/drms/drms_drone/MultiData;->setControllerConnected(Z)V

    .line 83
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;

    move-result-object v3

    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.drms.drms_drone.CONNECTED_CONTROLLER"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 105
    .end local v0    # "data":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 87
    .restart local v0    # "data":Ljava/lang/String;
    :cond_1
    move-object v1, p1

    .line 88
    .local v1, "datain":[B
    array-length v3, v1

    if-lez v3, :cond_0

    .line 91
    iget-object v3, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v3}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/os/Handler;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 92
    new-instance v3, Ljava/lang/Thread;

    new-instance v4, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;

    invoke-direct {v4, p0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1$1;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;[B)V

    invoke-direct {v3, v4}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 97
    invoke-virtual {v3}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 102
    .end local v0    # "data":Ljava/lang/String;
    .end local v1    # "datain":[B
    :catch_0
    move-exception v2

    .line 103
    .local v2, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v2}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0
.end method
