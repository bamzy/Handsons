.class Lcom/drms/drms_drone/Upload/UploadManager$7$1;
.super Ljava/lang/Object;
.source "UploadManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Upload/UploadManager$7;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Upload/UploadManager$7;)V
    .locals 0
    .param p1, "this$1"    # Lcom/drms/drms_drone/Upload/UploadManager$7;

    .prologue
    .line 341
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 344
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1000(Lcom/drms/drms_drone/Upload/UploadManager;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 345
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    const/4 v2, 0x0

    invoke-static {v1, v2}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 346
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v1

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 347
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v1

    aget-object v1, v1, v0

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v2, v2, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v2}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1200(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 346
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 350
    .end local v0    # "i":I
    :cond_0
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1002(Lcom/drms/drms_drone/Upload/UploadManager;Z)Z

    .line 351
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v1

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 352
    iget-object v1, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v1, v1, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v1}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1100(Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;

    move-result-object v1

    aget-object v1, v1, v0

    iget-object v2, p0, Lcom/drms/drms_drone/Upload/UploadManager$7$1;->this$1:Lcom/drms/drms_drone/Upload/UploadManager$7;

    iget-object v2, v2, Lcom/drms/drms_drone/Upload/UploadManager$7;->this$0:Lcom/drms/drms_drone/Upload/UploadManager;

    invoke-static {v2}, Lcom/drms/drms_drone/Upload/UploadManager;->access$1300(Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 351
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 354
    :cond_1
    return-void
.end method
