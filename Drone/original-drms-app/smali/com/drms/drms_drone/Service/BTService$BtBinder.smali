.class public Lcom/drms/drms_drone/Service/BTService$BtBinder;
.super Landroid/os/Binder;
.source "BTService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Service/BTService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BtBinder"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Service/BTService;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Service/BTService;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Service/BTService;

    .prologue
    .line 122
    iput-object p1, p0, Lcom/drms/drms_drone/Service/BTService$BtBinder;->this$0:Lcom/drms/drms_drone/Service/BTService;

    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    return-void
.end method


# virtual methods
.method public getService()Lcom/drms/drms_drone/Service/BTService;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/drms/drms_drone/Service/BTService$BtBinder;->this$0:Lcom/drms/drms_drone/Service/BTService;

    return-object v0
.end method
