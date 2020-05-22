.class Lcom/drms/drms_drone/Activity/DroneMainActivity$8;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;
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
    .line 495
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;
    .param p2, "arg1"    # Landroid/os/IBinder;

    .prologue
    .line 498
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    check-cast p2, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;

    .end local p2    # "arg1":Landroid/os/IBinder;
    invoke-virtual {p2}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;->getService()Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .line 499
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->setHandler(Landroid/os/Handler;)V

    .line 500
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 2
    .param p1, "arg0"    # Landroid/content/ComponentName;

    .prologue
    .line 504
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$8;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1502(Lcom/drms/drms_drone/Activity/DroneMainActivity;Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .line 505
    return-void
.end method
