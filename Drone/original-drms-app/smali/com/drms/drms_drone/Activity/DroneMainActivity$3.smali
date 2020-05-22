.class Lcom/drms/drms_drone/Activity/DroneMainActivity$3;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;->implementationDrawerList()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;


# direct methods
.method constructor <init>(Lcom/drms/drms_drone/Activity/DroneMainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/drms/drms_drone/Activity/DroneMainActivity;

    .prologue
    .line 354
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$3;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 357
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$3;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v1}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 358
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    const-string v2, "http://drmakersystem.com"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 359
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$3;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    const/4 v2, 0x7

    invoke-virtual {v1, v0, v2}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 360
    return-void
.end method
