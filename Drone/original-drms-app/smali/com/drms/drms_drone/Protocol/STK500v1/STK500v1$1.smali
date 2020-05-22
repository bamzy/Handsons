.class Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;
.super Landroid/os/Handler;
.source "STK500v1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

.field toast_state:Z


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;)V
    .locals 1
    .param p1, "this$0"    # Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 71
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->toast_state:Z

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/16 v6, 0x15

    const/16 v5, 0x14

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 75
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 76
    iget v2, p1, Landroid/os/Message;->what:I

    packed-switch v2, :pswitch_data_0

    .line 132
    :cond_0
    :goto_0
    return-void

    .line 78
    :pswitch_0
    iget v2, p1, Landroid/os/Message;->arg1:I

    int-to-byte v0, v2

    .line 79
    .local v0, "orient_command":B
    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v2, [B

    move-object v1, v2

    check-cast v1, [B

    .line 81
    .local v1, "received_message":[B
    sparse-switch v0, :sswitch_data_0

    goto :goto_0

    .line 83
    :sswitch_0
    aget-byte v2, v1, v3

    if-ne v2, v5, :cond_1

    .line 84
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    goto :goto_0

    .line 85
    :cond_1
    aget-byte v2, v1, v3

    if-ne v2, v6, :cond_0

    .line 86
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_entered:Z

    goto :goto_0

    .line 91
    :sswitch_1
    aget-byte v2, v1, v3

    if-ne v2, v5, :cond_2

    .line 92
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    goto :goto_0

    .line 93
    :cond_2
    aget-byte v2, v1, v3

    if-ne v2, v6, :cond_0

    .line 94
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programMode_left:Z

    goto :goto_0

    .line 99
    :sswitch_2
    aget-byte v2, v1, v3

    if-ne v2, v5, :cond_3

    .line 100
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_success:Z

    .line 101
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    goto :goto_0

    .line 103
    :cond_3
    aget-byte v2, v1, v3

    if-ne v2, v6, :cond_4

    .line 104
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_success:Z

    .line 105
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    goto :goto_0

    .line 108
    :cond_4
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_success:Z

    .line 109
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->loadAddress_each_success:Z

    goto :goto_0

    .line 115
    :sswitch_3
    aget-byte v2, v1, v3

    if-ne v2, v5, :cond_5

    .line 116
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    .line 117
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v4, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    goto :goto_0

    .line 119
    :cond_5
    aget-byte v2, v1, v3

    if-ne v2, v6, :cond_6

    .line 120
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    .line 121
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    goto :goto_0

    .line 124
    :cond_6
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_success:Z

    .line 125
    iget-object v2, p0, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1$1;->this$0:Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;

    iput-boolean v3, v2, Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;->programPage_each_success:Z

    goto :goto_0

    .line 76
    nop

    :pswitch_data_0
    .packed-switch 0x15
        :pswitch_0
    .end packed-switch

    .line 81
    :sswitch_data_0
    .sparse-switch
        0x50 -> :sswitch_0
        0x51 -> :sswitch_1
        0x55 -> :sswitch_2
        0x64 -> :sswitch_3
    .end sparse-switch
.end method
