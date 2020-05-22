.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$1;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


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
    .line 94
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->dismiss()V

    .line 98
    return-void
.end method
