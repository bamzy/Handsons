.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;
.super Landroid/widget/LinearLayout;
.source "Custom1_View.java"


# instance fields
.field icon:Landroid/widget/ImageView;

.field name:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "iconbox"    # Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 24
    const-string v1, "layout_inflater"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 25
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v1, 0x7f040027

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 27
    const v1, 0x7f0d0034

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->icon:Landroid/widget/ImageView;

    .line 28
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->icon:Landroid/widget/ImageView;

    invoke-virtual {p2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 30
    const v1, 0x7f0d008b

    invoke-virtual {p0, v1}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->name:Landroid/widget/TextView;

    .line 31
    iget-object v1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->name:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 33
    return-void
.end method


# virtual methods
.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->icon:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 41
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_View;->name:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 37
    return-void
.end method
