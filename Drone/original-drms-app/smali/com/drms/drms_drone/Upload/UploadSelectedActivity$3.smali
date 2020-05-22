.class Lcom/drms/drms_drone/Upload/UploadSelectedActivity$3;
.super Landroid/os/Handler;
.source "UploadSelectedActivity.java"


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
    .line 144
    iput-object p1, p0, Lcom/drms/drms_drone/Upload/UploadSelectedActivity$3;->this$0:Lcom/drms/drms_drone/Upload/UploadSelectedActivity;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 0
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 147
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 148
    return-void
.end method
