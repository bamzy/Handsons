.class Lcom/drms/drms_drone/Activity/MainActivity$1$1;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/MainActivity$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Activity/MainActivity$1;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/MainActivity$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Activity/MainActivity$1;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/MainActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/MainActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 63
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/MainActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/MainActivity$1;

    iget-object v0, v0, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/MainActivity;->access$200(Lcom/drms/drms_drone/Activity/MainActivity;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/drms/drms_drone/Activity/MainActivity$1$1;->this$1:Lcom/drms/drms_drone/Activity/MainActivity$1;

    iget-object v1, v1, Lcom/drms/drms_drone/Activity/MainActivity$1;->this$0:Lcom/drms/drms_drone/Activity/MainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/MainActivity;->access$100(Lcom/drms/drms_drone/Activity/MainActivity;)I

    move-result v1

    int-to-float v1, v1

    const/high16 v2, 0x437f0000    # 255.0f

    div-float/2addr v1, v2

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setAlpha(F)V

    .line 64
    return-void
.end method
