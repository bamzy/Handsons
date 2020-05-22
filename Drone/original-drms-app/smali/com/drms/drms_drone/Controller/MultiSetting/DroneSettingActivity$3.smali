.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$3;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$3;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$3;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-virtual {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->finish()V

    .line 113
    return-void
.end method
