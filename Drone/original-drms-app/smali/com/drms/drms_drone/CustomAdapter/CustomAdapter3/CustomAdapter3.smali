.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;
.super Landroid/widget/BaseAdapter;
.source "CustomAdapter3.java"


# instance fields
.field private mContext:Landroid/content/Context;

.field private mItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 21
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    .line 24
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mContext:Landroid/content/Context;

    .line 25
    return-void
.end method


# virtual methods
.method public addItem(Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V
    .locals 1
    .param p1, "item"    # Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 59
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 34
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 39
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 44
    if-nez p2, :cond_0

    .line 45
    new-instance v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;

    iget-object v2, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-direct {v0, v2, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;-><init>(Landroid/content/Context;Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V

    .line 50
    .local v0, "itemView":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;
    :goto_0
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 51
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {v1, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getData(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v3, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->setText(ILjava/lang/String;)V

    .line 52
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    invoke-virtual {v1, v4}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getData(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v4, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->setText(ILjava/lang/String;)V

    .line 54
    return-object v0

    .end local v0    # "itemView":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;
    :cond_0
    move-object v0, p2

    .line 47
    check-cast v0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;

    .restart local v0    # "itemView":Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;
    goto :goto_0
.end method

.method public removeItem()V
    .locals 3

    .prologue
    .line 62
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 65
    :cond_0
    const-string v0, "ContentValues"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "remove size : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/CustomAdapter3;->mItems:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 66
    return-void
.end method
