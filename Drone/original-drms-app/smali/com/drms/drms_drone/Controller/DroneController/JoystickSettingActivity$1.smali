.class Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;
.super Ljava/lang/Object;
.source "JoystickSettingActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 11
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    const v10, 0x7f0c0027

    const v9, 0x7f0c0026

    const/4 v8, -0x1

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 66
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_1

    .line 67
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 117
    :cond_0
    :goto_0
    :pswitch_0
    return v6

    .line 69
    :pswitch_1
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aput-boolean v6, v3, v7

    goto :goto_0

    .line 73
    :pswitch_2
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aput-boolean v6, v3, v6

    goto :goto_0

    .line 78
    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-ne v3, v6, :cond_0

    .line 80
    const-wide/16 v4, 0x1e

    :try_start_0
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :goto_1
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$100(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v3

    invoke-virtual {v3, v7}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 83
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_1

    :pswitch_3
    goto :goto_0

    .line 85
    :pswitch_4
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aget-boolean v3, v3, v7

    if-eqz v3, :cond_0

    .line 86
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aput-boolean v7, v3, v7

    .line 87
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_2
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    array-length v3, v3

    if-ge v0, v3, :cond_2

    .line 88
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    aget-object v3, v3, v0

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 87
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 90
    :cond_2
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    aget-object v3, v3, v7

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 92
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 93
    new-instance v1, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-direct {v1, v3, v4}, Lcom/drms/drms_drone/Controller/DroneController/Setting1View;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    .line 94
    .local v1, "setting1":Landroid/view/View;
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v8, v8}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v1, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 95
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 100
    .end local v0    # "i":I
    .end local v1    # "setting1":Landroid/view/View;
    :pswitch_5
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aget-boolean v3, v3, v6

    if-eqz v3, :cond_0

    .line 101
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$000(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Z

    move-result-object v3

    aput-boolean v7, v3, v6

    .line 102
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_3
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    array-length v3, v3

    if-ge v0, v3, :cond_3

    .line 103
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    aget-object v3, v3, v0

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 102
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 105
    :cond_3
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)[Landroid/widget/LinearLayout;

    move-result-object v3

    aget-object v3, v3, v6

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-virtual {v4}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 107
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 108
    new-instance v2, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;

    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    iget-object v4, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-direct {v2, v3, v4}, Lcom/drms/drms_drone/Controller/DroneController/Setting2View;-><init>(Landroid/content/Context;Landroid/app/Activity;)V

    .line 109
    .local v2, "setting2":Landroid/view/View;
    new-instance v3, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v3, v8, v8}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 110
    iget-object v3, p0, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity$1;->this$0:Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;->access$300(Lcom/drms/drms_drone/Controller/DroneController/JoystickSettingActivity;)Landroid/widget/LinearLayout;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 81
    .end local v0    # "i":I
    .end local v2    # "setting2":Landroid/view/View;
    :catch_0
    move-exception v3

    goto/16 :goto_1

    .line 67
    :pswitch_data_0
    .packed-switch 0x7f0d0082
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch

    .line 83
    :pswitch_data_1
    .packed-switch 0x7f0d0082
        :pswitch_4
        :pswitch_3
        :pswitch_5
    .end packed-switch
.end method
