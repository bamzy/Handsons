.class Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$1;
.super Ljava/lang/Object;
.source "DeviceListActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 77
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$1;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity$1;->this$0:Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;->access$000(Lcom/drms/drms_drone/Communication/ClassicBluetooth/DeviceListActivity;)V

    .line 81
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 82
    return-void
.end method
