.class Lcom/drms/drms_drone/Activity/DroneMainActivity$10;
.super Landroid/content/BroadcastReceiver;
.source "DroneMainActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 717
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const v10, 0x7f0c0012

    const v9, 0x7f03000e

    const/16 v6, 0x8

    const v8, 0x7f030004

    const/4 v7, 0x0

    .line 720
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    .line 721
    .local v1, "action":Ljava/lang/String;
    const-string v4, "connected bluetooth in Service"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 722
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v4

    invoke-virtual {v4, v6}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 723
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f030005

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 724
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 726
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 727
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 728
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 729
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$300(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 855
    :cond_0
    :goto_0
    return-void

    .line 748
    :cond_1
    const-string v4, "disconnected bluetooth in Service"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 749
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "in main disconnected"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 750
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 751
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c0013

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 752
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0c0013

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 753
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, " Disconnected..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 754
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/Playflight;

    move-result-object v4

    invoke-virtual {v4}, Lcom/drms/drms_drone/MainView/Playflight;->invalidate()V

    .line 755
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 756
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v5, 0x1

    invoke-static {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1702(Lcom/drms/drms_drone/Activity/DroneMainActivity;Z)Z

    goto :goto_0

    .line 761
    :cond_2
    const-string v4, "failed bluetooth in Service"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 762
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 763
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, " Disconnected..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 764
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 773
    :cond_3
    const-string v4, "android.intent.action.CLOSE_SYSTEM_DIALOGS"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 774
    const-string v4, "reason"

    invoke-virtual {p2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 775
    .local v3, "reason":Ljava/lang/String;
    if-eqz v3, :cond_0

    .line 776
    const-string v4, "homekey"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 778
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request nothing"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 779
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request_finish_service"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 780
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 781
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, " Disconnected..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 782
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 783
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/BroadcastReceiver;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 784
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1900(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 785
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$2000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    goto/16 :goto_0

    .line 793
    .end local v3    # "reason":Ljava/lang/String;
    :cond_4
    const-string v4, "discover bluetooth"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 794
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 795
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_0

    .line 797
    :cond_5
    const-string v4, "discovr failed"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 798
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 799
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 800
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ProgressBar;

    move-result-object v4

    invoke-virtual {v4, v6}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto/16 :goto_0

    .line 803
    :cond_6
    const-string v4, "com.felhr.usbservice.USB_PERMISSION_GRANTED"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 806
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "USB Device is connected -> check Controller\n"

    invoke-static {v4, v5}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0

    .line 811
    :cond_7
    const-string v4, "com.felhr.usbservice.USB_PERMISSION_NOT_GRANTED"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_8

    .line 812
    const-string v4, "\uc870\uc885\uae30 \uad8c\ud55c\uc774 \uac70\ubd80\ub418\uc5b4 \uc5f0\uacb0\ud560 \uc218 \uc5c6\uc2b5\ub2c8\ub2e4."

    invoke-static {p1, v4, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    goto/16 :goto_0

    .line 815
    :cond_8
    const-string v4, "com.felhr.usbservice.NO_USB"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 818
    const-string v4, "com.felhr.usbservice.USB_DISCONNECTED"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_9

    .line 819
    const-string v4, "\uc7a5\uce58\uac00 \ubd84\ub9ac\ub418\uc5c8\uc2b5\ub2c8\ub2e4"

    invoke-static {p1, v4, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 820
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$2100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 821
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const v5, 0x7f0d0078

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 822
    .local v0, "Cont_text":Landroid/widget/TextView;
    const-string v4, "Controller\ndisconnected"

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 823
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0c001a

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 825
    .end local v0    # "Cont_text":Landroid/widget/TextView;
    :cond_9
    const-string v4, "com.felhr.usbservice.USB_NOT_SUPPORTED"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 826
    const-string v4, "USB device not supported"

    invoke-static {p1, v4, v7}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v4

    invoke-virtual {v4}, Landroid/widget/Toast;->show()V

    .line 827
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->finish()V

    goto/16 :goto_0

    .line 829
    :cond_a
    const-string v4, "com.drms.drms_drone.CONNECTED_CONTROLLER"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_b

    .line 830
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$2100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 831
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const v5, 0x7f0d0078

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 832
    .restart local v0    # "Cont_text":Landroid/widget/TextView;
    const-string v4, "Controller\nConnected"

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 833
    const v4, -0xffff01

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 836
    .end local v0    # "Cont_text":Landroid/widget/TextView;
    :cond_b
    const-string v4, "con.drms.drms_drone.NEXT_DISPLAY"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 837
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1100(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MainView/Playflight;

    move-result-object v4

    invoke-virtual {v4}, Lcom/drms/drms_drone/MainView/Playflight;->executeController()V

    goto/16 :goto_0

    .line 839
    :cond_c
    const-string v4, "com.drms.drms_drone.PREVIOUS_DISPLAY"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 840
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request nothing"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 841
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    new-instance v5, Landroid/content/Intent;

    const-string v6, "request_finish_service"

    invoke-direct {v5, v6}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 842
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$600(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/ImageView;

    move-result-object v4

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 843
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$700(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, " Disconnected..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 844
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$800(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/widget/TextView;

    move-result-object v4

    const-string v5, "..."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 846
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1900(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 847
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    iget-object v5, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$2000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/content/ServiceConnection;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 849
    const-string v2, "#bye"

    .line 850
    .local v2, "bye_msg":Ljava/lang/String;
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$2200(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/drms/drms_drone/MultiData;->setControllerConnected(Z)V

    .line 851
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1500(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;

    move-result-object v4

    invoke-virtual {v2}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/UsbService;->write([B)V

    .line 852
    iget-object v4, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$10;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->finish()V

    goto/16 :goto_0
.end method
