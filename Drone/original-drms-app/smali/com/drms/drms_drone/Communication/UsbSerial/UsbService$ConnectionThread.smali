.class Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;
.super Ljava/lang/Thread;
.source "UsbService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConnectionThread"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;


# direct methods
.method private constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V
    .locals 0

    .prologue
    .line 279
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .param p2, "x1"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$1;

    .prologue
    .line 279
    invoke-direct {p0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;-><init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 282
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$700(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbDevice;

    move-result-object v6

    iget-object v7, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v7}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$600(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/hardware/usb/UsbDeviceConnection;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->createUsbSerialDevice(Landroid/hardware/usb/UsbDevice;Landroid/hardware/usb/UsbDeviceConnection;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1202(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    .line 283
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 284
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    invoke-virtual {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->open()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 285
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5, v9}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 286
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    const v6, 0xe100

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->setBaudRate(I)V

    .line 287
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->setDataBits(I)V

    .line 288
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    invoke-virtual {v5, v9}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->setStopBits(I)V

    .line 289
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    invoke-virtual {v5, v8}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->setParity(I)V

    .line 296
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    invoke-virtual {v5, v8}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->setFlowControl(I)V

    .line 297
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->read(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbReadCallback;)I

    .line 298
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1400(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->getCTS(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbCTSCallback;)V

    .line 299
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    iget-object v6, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1500(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;->getDSR(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface$UsbDSRCallback;)V

    .line 307
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.felhr.connectivityservices.USB_READY"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 308
    .local v4, "intent":Landroid/content/Intent;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 309
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5, v8}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$002(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;Z)Z

    .line 310
    :goto_0
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z

    move-result v5

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$100(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z

    move-result v5

    if-ne v5, v9, :cond_0

    .line 311
    const-string v3, "#hello"

    .line 312
    .local v3, "hello_msg":Ljava/lang/String;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-virtual {v3}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->write([B)V

    .line 314
    const-wide/16 v6, 0x3e8

    :try_start_0
    invoke-static {v6, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 315
    :catch_0
    move-exception v0

    .line 316
    .local v0, "e":Ljava/lang/InterruptedException;
    const-string v5, "UsbService"

    const-string v6, "Interrupted Exception for connected to Arduino"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 320
    .end local v0    # "e":Ljava/lang/InterruptedException;
    .end local v3    # "hello_msg":Ljava/lang/String;
    :cond_0
    :goto_1
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$000(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 321
    const-string v2, "#get"

    .line 322
    .local v2, "get_msg":Ljava/lang/String;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->write([B)V

    .line 324
    const-wide/16 v6, 0x32

    :try_start_1
    invoke-static {v6, v7}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_1

    .line 325
    :catch_1
    move-exception v1

    .line 326
    .local v1, "e1":Ljava/lang/InterruptedException;
    const-string v5, "UsbService"

    const-string v6, "InterruptedException occured"

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 332
    .end local v1    # "e1":Ljava/lang/InterruptedException;
    .end local v2    # "get_msg":Ljava/lang/String;
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_1
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$1200(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialDevice;

    move-result-object v5

    instance-of v5, v5, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/CDCSerialDevice;

    if-eqz v5, :cond_3

    .line 333
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.felhr.connectivityservices.ACTION_CDC_DRIVER_NOT_WORKING"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 334
    .restart local v4    # "intent":Landroid/content/Intent;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 345
    :cond_2
    :goto_2
    return-void

    .line 336
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_3
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.felhr.connectivityservices.ACTION_USB_DEVICE_NOT_WORKING"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 337
    .restart local v4    # "intent":Landroid/content/Intent;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_2

    .line 342
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_4
    new-instance v4, Landroid/content/Intent;

    const-string v5, "com.felhr.usbservice.USB_NOT_SUPPORTED"

    invoke-direct {v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 343
    .restart local v4    # "intent":Landroid/content/Intent;
    iget-object v5, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$ConnectionThread;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-static {v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->access$300(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5, v4}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_2
.end method
