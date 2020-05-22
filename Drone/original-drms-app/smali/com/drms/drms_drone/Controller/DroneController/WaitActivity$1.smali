.class Lcom/drms/drms_drone/Controller/DroneController/WaitActivity$1;
.super Ljava/lang/Object;
.source "WaitActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/DroneController/WaitActivity;->finish()V

    .line 36
    return-void
.end method
