.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;
.super Landroid/widget/BaseAdapter;
.source "CustomAdapter1.java"


# instance fields
.field private IconBox:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;",
            ">;"
        }
    .end annotation
.end field

.field private mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 19
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    .line 20
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->mContext:Landroid/content/Context;

    .line 21
    return-void
.end method


# virtual methods
.method public addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V
    .locals 1
    .param p1, "item"    # Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    .prologue
    .line 51
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 52
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "i"    # I

    .prologue
    .line 29
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 34
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 3
    .param p1, "position"    # I
    .param p2, "converView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 39
    if-nez p2, :cond_0

    .line 40
    new-instance v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;

    iget-object v2, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-direct {v0, v2, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;-><init>(Landroid/content/Context;Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V

    .line 44
    .local v0, "itembox":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 45
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;->IconBox:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    invoke-virtual {v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->setName(Ljava/lang/String;)V

    .line 47
    return-object v0

    .end local v0    # "itembox":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;
    :cond_0
    move-object v0, p2

    .line 42
    check-cast v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;

    .restart local v0    # "itembox":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;
    goto :goto_0
.end method
