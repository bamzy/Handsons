.class public Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;
.super Landroid/os/Binder;
.source "UsbService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UsbBinder"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    .prologue
    .line 269
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method


# virtual methods
.method public getService()Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService$UsbBinder;->this$0:Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    return-object v0
.end method
