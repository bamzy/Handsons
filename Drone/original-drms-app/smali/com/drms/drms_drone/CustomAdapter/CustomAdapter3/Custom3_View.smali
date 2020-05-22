.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;
.super Landroid/widget/LinearLayout;
.source "Custom3_View.java"


# instance fields
.field mIcon:Landroid/widget/ImageView;

.field public mtext01:Landroid/widget/TextView;

.field mtext02:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aItem"    # Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;

    .prologue
    const/4 v3, 0x1

    .line 23
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 24
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0001

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->setBackgroundColor(I)V

    .line 26
    const-string v1, "layout_inflater"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 27
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f040029

    invoke-virtual {v0, v1, p0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 29
    const v1, 0x7f0d008c

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mIcon:Landroid/widget/ImageView;

    .line 30
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {p2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 32
    const v1, 0x7f0d008d

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext01:Landroid/widget/TextView;

    .line 33
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext01:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {p2, v2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getData(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    const v1, 0x7f0d008e

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext02:Landroid/widget/TextView;

    .line 36
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext02:Landroid/widget/TextView;

    invoke-virtual {p2, v3}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->getData(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    return-void
.end method


# virtual methods
.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mIcon:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 54
    return-void
.end method

.method public setText(ILjava/lang/String;)V
    .locals 1
    .param p1, "index"    # I
    .param p2, "data"    # Ljava/lang/String;

    .prologue
    .line 40
    if-nez p1, :cond_0

    .line 41
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext01:Landroid/widget/TextView;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 49
    :goto_0
    return-void

    .line 43
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 44
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_View;->mtext02:Landroid/widget/TextView;

    invoke-virtual {v0, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 47
    :cond_1
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v0
.end method
