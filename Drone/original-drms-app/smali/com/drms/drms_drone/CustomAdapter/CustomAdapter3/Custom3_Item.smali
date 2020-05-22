.class public Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;
.super Ljava/lang/Object;
.source "Custom3_Item.java"


# instance fields
.field private mData:[Ljava/lang/String;

.field private mIcon:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "obj01"    # Ljava/lang/String;
    .param p3, "obj02"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 26
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    .line 27
    if-eqz p2, :cond_0

    .line 28
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    aput-object p2, v0, v2

    .line 33
    :goto_0
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    const/4 v1, 0x1

    aput-object p3, v0, v1

    .line 34
    return-void

    .line 31
    :cond_0
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    const-string v1, "Unknown"

    aput-object v1, v0, v2

    goto :goto_0
.end method

.method public constructor <init>(Landroid/graphics/drawable/Drawable;[Ljava/lang/String;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;
    .param p2, "obj"    # [Ljava/lang/String;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 19
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 20
    iput-object p2, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    .line 21
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "obj"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    const/4 v1, 0x0

    aput-object p1, v0, v1

    .line 16
    return-void
.end method


# virtual methods
.method public getData(I)Ljava/lang/String;
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 41
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    array-length v0, v0

    if-lt p1, v0, :cond_1

    .line 42
    :cond_0
    const/4 v0, 0x0

    .line 45
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    aget-object v0, v0, p1

    goto :goto_0
.end method

.method public getData()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    return-object v0
.end method

.method public getIcon()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mIcon:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public setData([Ljava/lang/String;)V
    .locals 0
    .param p1, "obj"    # [Ljava/lang/String;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mData:[Ljava/lang/String;

    .line 50
    return-void
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/drms/drms_drone/CustomAdapter/CustomAdapter3/Custom3_Item;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 54
    return-void
.end method
