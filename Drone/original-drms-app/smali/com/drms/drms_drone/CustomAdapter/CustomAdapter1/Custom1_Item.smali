.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;
.super Ljava/lang/Object;
.source "Custom1_Item.java"


# instance fields
.field private icon:Landroid/graphics/drawable/Drawable;

.field private name:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->icon:Landroid/graphics/drawable/Drawable;

    .line 16
    iput-object p2, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->name:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->icon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->name:Ljava/lang/String;

    return-object v0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 32
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->icon:Landroid/graphics/drawable/Drawable;

    .line 33
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 28
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/Custom1_Item;->name:Ljava/lang/String;

    .line 29
    return-void
.end method
