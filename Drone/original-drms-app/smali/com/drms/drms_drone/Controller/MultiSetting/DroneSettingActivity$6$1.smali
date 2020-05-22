.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    .prologue
    .line 346
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;->this$1:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 349
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;->this$1:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    iget-object v0, v0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$5000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;->this$1:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    iget-object v1, v1, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->val$form:Ljava/text/DecimalFormat;

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6$1;->this$1:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;

    iget-object v2, v2, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$6;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v2}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2}, Lcom/drms/drms_drone/MultiData;->getAnalogData()[F

    move-result-object v2

    const/4 v3, 0x0

    aget v2, v2, v3

    float-to-double v2, v2

    invoke-virtual {v1, v2, v3}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 350
    return-void
.end method
