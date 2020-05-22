.class Lcom/drms/drms_drone/Activity/DroneMainActivity$5;
.super Ljava/lang/Object;
.source "DroneMainActivity.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Activity/DroneMainActivity;
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
    .line 395
    iput-object p1, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$5;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "view"    # Landroid/view/View;
    .param p2, "motionEvent"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 398
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    .line 437
    :cond_0
    :goto_0
    return v2

    .line 401
    :cond_1
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 402
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$5;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Lcom/drms/drms_drone/Sound/SoundManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/Sound/SoundManager;->play(I)V

    .line 403
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    goto :goto_0

    .line 431
    :pswitch_0
    iget-object v0, p0, Lcom/drms/drms_drone/Activity/DroneMainActivity$5;->this$0:Lcom/drms/drms_drone/Activity/DroneMainActivity;

    invoke-static {v0}, Lcom/drms/drms_drone/Activity/DroneMainActivity;->access$1000(Lcom/drms/drms_drone/Activity/DroneMainActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const v1, 0x800003

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->openDrawer(I)V

    goto :goto_0

    .line 403
    nop

    :pswitch_data_0
    .packed-switch 0x7f0d0075
        :pswitch_0
    .end packed-switch
.end method
