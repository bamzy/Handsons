.class Lcom/drms/drms_drone/Service/BTService$8$2;
.super Ljava/lang/Object;
.source "BTService.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Service/BTService$8;->handleMessage(Landroid/os/Message;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Service/BTService$8;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Service/BTService$8;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Service/BTService$8;

    .prologue
    .line 779
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 782
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    invoke-virtual {v2, v5}, Lcom/drms/drms_drone/MultiData;->setMAGCalibration(Z)V

    .line 783
    const-string v2, "BTService"

    const-string v3, "received mag cali"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 784
    const-string v0, "\uc9c0\uc790\uacc4 \uc13c\uc11c \uad50\uc815\uc774 \uc644\ub8cc\ub418\uc5c8\uc2b5\ub2c8\ub2e4."

    .line 785
    .local v0, "finishMag":Ljava/lang/String;
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$000(Lcom/drms/drms_drone/Service/BTService;)Landroid/speech/tts/TextToSpeech;

    move-result-object v2

    const/4 v3, 0x1

    const/4 v4, 0x0

    invoke-virtual {v2, v0, v3, v4}, Landroid/speech/tts/TextToSpeech;->speak(Ljava/lang/String;ILjava/util/HashMap;)I

    .line 786
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2, v5}, Lcom/drms/drms_drone/Service/BTService;->access$1302(Lcom/drms/drms_drone/Service/BTService;Z)Z

    .line 787
    const/4 v1, 0x1

    .local v1, "i":I
    :goto_0
    const/4 v2, 0x4

    if-ge v1, v2, :cond_0

    .line 788
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1500(Lcom/drms/drms_drone/Service/BTService;)Lcom/drms/drms_drone/MultiData;

    move-result-object v2

    const/16 v3, 0x3e8

    invoke-virtual {v2, v1, v3}, Lcom/drms/drms_drone/MultiData;->setRawRCDataAux(II)V

    .line 787
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 790
    :cond_0
    iget-object v2, p0, Lcom/drms/drms_drone/Service/BTService$8$2;->this$1:Lcom/drms/drms_drone/Service/BTService$8;

    iget-object v2, v2, Lcom/drms/drms_drone/Service/BTService$8;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-static {v2}, Lcom/drms/drms_drone/Service/BTService;->access$1600(Lcom/drms/drms_drone/Service/BTService;)Landroid/os/Handler;

    move-result-object v2

    new-instance v3, Lcom/drms/drms_drone/Service/BTService$8$2$1;

    invoke-direct {v3, p0}, Lcom/drms/drms_drone/Service/BTService$8$2$1;-><init>(Lcom/drms/drms_drone/Service/BTService$8$2;)V

    const-wide/16 v4, 0x1f4

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 797
    return-void
.end method
