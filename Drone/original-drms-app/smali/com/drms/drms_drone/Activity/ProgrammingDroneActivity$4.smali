.class Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$4;
.super Landroid/content/BroadcastReceiver;
.source "ProgrammingDroneActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    .prologue
    .line 119
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$4;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 123
    return-void
.end method
