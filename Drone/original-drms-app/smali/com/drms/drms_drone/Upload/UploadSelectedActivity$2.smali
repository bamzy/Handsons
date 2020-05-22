.class Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;
.super Ljava/lang/Object;
.source "UploadSelectedActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Upload/UploadSelectedActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

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
    .line 119
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v0, -0x1

    .line 120
    .local v0, "request":I
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$000(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 121
    packed-switch p3, :pswitch_data_0

    .line 134
    :goto_0
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 135
    new-instance v1, Lcom/drms/drms_drone/Upload/UploadManager;

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    iget-object v3, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v3}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$100(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;

    move-result-object v3

    iget-object v4, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-static {v4}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->access$200(Lcom/drms/drms_drone/Upload/UploadSelectedActivity;)Lcom/drms/drms_drone/FileManagement/FileManagement;

    move-result-object v4

    invoke-virtual {v4}, Lcom/drms/drms_drone/FileManagement/FileManagement;->readBTAddress()[Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-direct {v1, v2, v3, v4, v0}, Lcom/drms/drms_drone/Upload/UploadManager;-><init>(Landroid/app/Activity;Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;Ljava/lang/String;I)V

    .line 141
    :goto_1
    return-void

    .line 123
    :pswitch_0
    const/4 v0, 0x3

    .line 124
    goto :goto_0

    .line 127
    :pswitch_1
    const/4 v0, 0x4

    .line 128
    goto :goto_0

    .line 131
    :pswitch_2
    const/4 v0, 0x5

    goto :goto_0

    .line 138
    :cond_0
    const-string v1, "UploadSelectActivity"

    const-string v2, "error request Drone"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$2;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-virtual {v1}, Lcom/drms/drms_drone/Upload/UploadSelectedActivity;->finish()V

    goto :goto_1

    .line 121
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
