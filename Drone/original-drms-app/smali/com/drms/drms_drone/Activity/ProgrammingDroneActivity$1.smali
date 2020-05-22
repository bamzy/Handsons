.class Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;
.super Ljava/lang/Object;
.source "ProgrammingDroneActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->onCreate(Landroid/os/Bundle;)V
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
    .line 42
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 45
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$000(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 46
    const-string v0, "ProgrammingDrone"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "altitude : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$100(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getALTITUDEdata()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\tvario : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity$1;->this$0:Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;->access$100(Lcom/drms/drms_drone/Activity/ProgrammingDroneActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getALTITUDEdata()[F

    move-result-object v2

    const/4 v3, 0x1

    aget v2, v2, v3

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 48
    const-wide/16 v0, 0xa

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 49
    :catch_0
    move-exception v0

    goto :goto_0

    .line 51
    :cond_0
    return-void
.end method
