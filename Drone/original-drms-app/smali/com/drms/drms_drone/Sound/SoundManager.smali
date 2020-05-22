.class public Lcom/drms/drms_drone/Sound/SoundManager;
.super Ljava/lang/Object;
.source "SoundManager.java"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mSoundPool:Landroid/media/SoundPool;

.field private map:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "mContext"    # Landroid/content/Context;

    .prologue
    const v4, 0x7f070001

    const/4 v3, 0x0

    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mContext:Landroid/content/Context;

    .line 27
    new-instance v0, Landroid/media/SoundPool;

    const/4 v1, 0x5

    const/4 v2, 0x3

    invoke-direct {v0, v1, v2, v3}, Landroid/media/SoundPool;-><init>(III)V

    iput-object v0, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mSoundPool:Landroid/media/SoundPool;

    .line 28
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Sound/SoundManager;->map:Ljava/util/HashMap;

    .line 30
    invoke-virtual {p0, v3, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->addSound(II)V

    .line 31
    const/4 v0, 0x1

    invoke-virtual {p0, v0, v4}, Lcom/drms/drms_drone/Sound/SoundManager;->addSound(II)V

    .line 32
    return-void
.end method


# virtual methods
.method public addSound(II)V
    .locals 4
    .param p1, "index"    # I
    .param p2, "resid"    # I

    .prologue
    .line 35
    iget-object v1, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mSoundPool:Landroid/media/SoundPool;

    iget-object v2, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mContext:Landroid/content/Context;

    const/4 v3, 0x1

    invoke-virtual {v1, v2, p2, v3}, Landroid/media/SoundPool;->load(Landroid/content/Context;II)I

    move-result v0

    .line 36
    .local v0, "id":I
    iget-object v1, p0, Lcom/drms/drms_drone/Sound/SoundManager;->map:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    return-void
.end method

.method public play(I)V
    .locals 7
    .param p1, "index"    # I

    .prologue
    const/high16 v2, 0x3f800000    # 1.0f

    .line 40
    const-string v0, "Sound"

    const-string v1, "play"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    const-wide/16 v0, 0x1

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 44
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mSoundPool:Landroid/media/SoundPool;

    iget-object v1, p0, Lcom/drms/drms_drone/Sound/SoundManager;->map:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v4, 0x1

    const/4 v5, 0x0

    move v3, v2

    move v6, v2

    invoke-virtual/range {v0 .. v6}, Landroid/media/SoundPool;->play(IFFIIF)I

    .line 45
    return-void

    .line 43
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public stopSound(I)V
    .locals 3
    .param p1, "index"    # I

    .prologue
    .line 50
    iget-object v1, p0, Lcom/drms/drms_drone/Sound/SoundManager;->mSoundPool:Landroid/media/SoundPool;

    iget-object v0, p0, Lcom/drms/drms_drone/Sound/SoundManager;->map:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v1, v0}, Landroid/media/SoundPool;->stop(I)V

    .line 51
    return-void
.end method
