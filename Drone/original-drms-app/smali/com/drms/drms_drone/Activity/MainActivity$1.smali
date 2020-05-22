.class Lcom/drms/drms_drone/Activity/MainActivity$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/MainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/MainActivity;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 58
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/MainActivity;->access$000(Lcom/drms/drms_drone/Activity/MainActivity;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 59
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/MainActivity;->access$100(Lcom/drms/drms_drone/Activity/MainActivity;)I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/MainActivity;->access$102(Lcom/drms/drms_drone/Activity/MainActivity;I)I

    .line 60
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    new-instance v1, Lcom/drms/drms_drone/Activity/MainActivity$1$1;

    invoke-direct {v1, p0}, Lcom/drms/drms_drone/Activity/MainActivity$1$1;-><init>(Lcom/drms/drms_drone/Activity/MainActivity$1;)V

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Activity/MainActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 68
    const-wide/16 v0, 0xf

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    :goto_1
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/MainActivity;->access$100(Lcom/drms/drms_drone/Activity/MainActivity;)I

    move-result v0

    const/16 v1, 0xff

    if-lt v0, v1, :cond_0

    .line 71
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/drms/drms_drone/Activity/MainActivity;->access$002(Lcom/drms/drms_drone/Activity/MainActivity;Z)Z

    .line 72
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/MainActivity;->access$400(Lcom/drms/drms_drone/Activity/MainActivity;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/MainActivity;->access$300(Lcom/drms/drms_drone/Activity/MainActivity;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 69
    :catch_0
    move-exception v0

    goto :goto_1

    .line 75
    :cond_1
    return-void
.end method
