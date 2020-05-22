.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->implementationRcSetting()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

.field final synthetic val$form:Ljava/text/DecimalFormat;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Ljava/text/DecimalFormat;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 342
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    iput-object p2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->val$form:Ljava/text/DecimalFormat;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 345
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 346
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    new-instance v1, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;-><init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 355
    const-wide/16 v0, 0x64

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 356
    :catch_0
    move-exception v0

    goto :goto_0

    .line 359
    :cond_0
    const-string v0, "DroneSettingActivity"

    const-string v1, "end of vbat"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 360
    return-void
.end method
