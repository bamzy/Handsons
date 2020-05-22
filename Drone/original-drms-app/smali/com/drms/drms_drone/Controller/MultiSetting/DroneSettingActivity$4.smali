.class Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;
.super Ljava/lang/Object;
.source "DroneSettingActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->initializeView()V
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
    .line 125
    iput-object p1, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 13
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v12, 0x4

    const/4 v11, 0x1

    const/4 v10, 0x0

    const/high16 v9, 0x447a0000    # 1000.0f

    const/high16 v8, 0x41200000    # 10.0f

    .line 128
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v6

    if-nez v6, :cond_1

    .line 129
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)I

    move-result v6

    packed-switch v6, :pswitch_data_0

    .line 232
    :cond_0
    :goto_0
    :pswitch_0
    return v11

    .line 135
    :pswitch_1
    const/4 v6, 0x7

    new-array v4, v6, [F

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 136
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v4, v10

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 137
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v4, v11

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 138
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 139
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 140
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getRCTUNEdata()[F

    move-result-object v6

    aget v6, v6, v12

    aput v6, v4, v12

    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 141
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 142
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v4, v6

    .line 145
    .local v4, "rctuneData":[F
    const/16 v6, 0xc

    new-array v0, v6, [F

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 146
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v6

    invoke-virtual {v6}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v6

    aget v6, v6, v10

    aput v6, v0, v10

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 147
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v0, v11

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 148
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x2

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 149
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x3

    aget v7, v7, v8

    aput v7, v0, v6

    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 150
    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v0, v12

    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 151
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x5

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 152
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x6

    aget v7, v7, v8

    aput v7, v0, v6

    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 153
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v7

    invoke-virtual {v7}, Lcom/drms/drms_drone/MultiData;->getMISCdata()[F

    move-result-object v7

    const/4 v8, 0x7

    aget v7, v7, v8

    aput v7, v0, v6

    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 154
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    const/16 v6, 0x9

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 155
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    const/16 v6, 0xa

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 156
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    const/16 v6, 0xb

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    .line 157
    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v0, v6

    .line 159
    .local v0, "miscData":[F
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v6

    invoke-virtual {v6, v4}, Lcom/drms/drms_drone/MultiData;->setRCTUNEdata([F)V

    .line 160
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/MultiData;

    move-result-object v6

    invoke-virtual {v6, v0}, Lcom/drms/drms_drone/MultiData;->setMISCdata([F)V

    .line 162
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    new-instance v7, Landroid/content/Intent;

    const-string v8, "request rc setting"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 166
    .end local v0    # "miscData":[F
    .end local v4    # "rctuneData":[F
    :pswitch_2
    const-string v6, "DroneSettingActivity"

    const-string v7, "send box data"

    invoke-static {v6, v7}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 167
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    new-instance v7, Landroid/content/Intent;

    const-string v8, "request box setting"

    invoke-direct {v7, v8}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 171
    :pswitch_3
    const/16 v6, 0xa

    new-array v3, v6, [F

    .line 172
    .local v3, "pid_p_temp":[F
    const/16 v6, 0xa

    new-array v2, v6, [F

    .line 173
    .local v2, "pid_i_temp":[F
    const/16 v6, 0xa

    new-array v1, v6, [F

    .line 175
    .local v1, "pid_d_temp":[F
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v8

    aput v6, v3, v10

    .line 176
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v8

    aput v6, v3, v11

    .line 177
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 178
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 179
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$1900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    const/high16 v7, 0x42c80000    # 100.0f

    mul-float/2addr v6, v7

    aput v6, v3, v12

    .line 180
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 181
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 182
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 183
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v8

    aput v7, v3, v6

    .line 184
    const/16 v6, 0x9

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v7

    const/16 v8, 0x9

    aget v7, v7, v8

    aput v7, v3, v6

    .line 186
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v9

    aput v6, v2, v10

    .line 187
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v9

    aput v6, v2, v11

    .line 188
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 189
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 190
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$2900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    mul-float/2addr v6, v9

    aput v6, v2, v12

    .line 191
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    const/high16 v8, 0x42c80000    # 100.0f

    mul-float/2addr v7, v8

    aput v7, v2, v6

    .line 192
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    const/high16 v8, 0x42c80000    # 100.0f

    mul-float/2addr v7, v8

    aput v7, v2, v6

    .line 193
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v2, v6

    .line 194
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v7

    const/16 v8, 0x8

    aget v7, v7, v8

    aput v7, v2, v6

    .line 195
    const/16 v6, 0x9

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v7

    const/16 v8, 0x9

    aget v7, v7, v8

    aput v7, v2, v6

    .line 197
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3400(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v1, v10

    .line 198
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3500(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v6

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v6

    aput v6, v1, v11

    .line 199
    const/4 v6, 0x2

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3600(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 200
    const/4 v6, 0x3

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3700(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 201
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v6

    aget v6, v6, v12

    aput v6, v1, v12

    .line 202
    const/4 v6, 0x5

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3900(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v1, v6

    .line 203
    const/4 v6, 0x6

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4000(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    mul-float/2addr v7, v9

    aput v7, v1, v6

    .line 204
    const/4 v6, 0x7

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4100(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/widget/EditText;

    move-result-object v7

    invoke-virtual {v7}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v7

    aput v7, v1, v6

    .line 205
    const/16 v6, 0x8

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v7

    const/16 v8, 0x8

    aget v7, v7, v8

    aput v7, v1, v6

    .line 206
    const/16 v6, 0x9

    iget-object v7, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v7}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$3800(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)[F

    move-result-object v7

    const/16 v8, 0x9

    aget v7, v7, v8

    aput v7, v1, v6

    .line 208
    new-instance v5, Landroid/content/Intent;

    invoke-direct {v5}, Landroid/content/Intent;-><init>()V

    .line 210
    .local v5, "requestSetting":Landroid/content/Intent;
    const-string v6, "P"

    invoke-virtual {v5, v6, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 211
    const-string v6, "I"

    invoke-virtual {v5, v6, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 212
    const-string v6, "D"

    invoke-virtual {v5, v6, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[F)Landroid/content/Intent;

    .line 213
    const-string v6, "request pid setting"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 215
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-virtual {v6, v5}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 223
    .end local v1    # "pid_d_temp":[F
    .end local v2    # "pid_i_temp":[F
    .end local v3    # "pid_p_temp":[F
    .end local v5    # "requestSetting":Landroid/content/Intent;
    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v6

    if-ne v6, v11, :cond_0

    .line 225
    const-wide/16 v6, 0x1e

    :try_start_0
    invoke-static {v6, v7}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 228
    :goto_1
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4200(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v6

    invoke-virtual {v6, v10}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 229
    iget-object v6, p0, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity$4;->this$0:Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;

    invoke-static {v6}, Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;->access$4300(Lcom/drms/drms_drone/Controller/MultiSetting/DroneSettingActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v6

    const v7, 0x800003

    invoke-virtual {v6, v7}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    goto/16 :goto_0

    .line 227
    :catch_0
    move-exception v6

    goto :goto_1

    .line 129
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
