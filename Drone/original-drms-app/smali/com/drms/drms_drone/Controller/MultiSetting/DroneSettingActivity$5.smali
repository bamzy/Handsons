.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->implementationDrawer()V
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
    .line 261
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v5, 0x0

    const v4, 0x800003

    .line 264
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4402(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Z)Z

    .line 265
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0, p3}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$102(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;I)I

    .line 266
    packed-switch p3, :pswitch_data_0

    .line 295
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v0

    invoke-virtual {v0, v5}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 296
    return-void

    .line 268
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 269
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    new-instance v1, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {v1, v2, v3}, Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4602(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;)Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    .line 270
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Controller/MultiSetting/MyDroneSettingView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 271
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto :goto_0

    .line 275
    :pswitch_1
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    .line 276
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto :goto_0

    .line 280
    :pswitch_2
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 281
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    new-instance v1, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    iget-object v2, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {v1, v2, v3}, Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4802(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;)Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    .line 282
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Controller/MultiSetting/BoxSettingView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 283
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto :goto_0

    .line 287
    :pswitch_3
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)V

    .line 288
    iget-object v0, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$5;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/widget/DrawerLayout;->closeDrawer(I)V

    goto/16 :goto_0

    .line 266
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
