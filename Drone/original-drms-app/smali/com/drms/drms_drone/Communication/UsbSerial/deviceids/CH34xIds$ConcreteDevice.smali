.class Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;
.super Ljava/lang/Object;
.source "CH34xIds.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ConcreteDevice"
.end annotation


# instance fields
.field public productId:I

.field public vendorId:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "vendorId"    # I
    .param p2, "productId"    # I

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;->vendorId:I

    .line 36
    iput p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;->productId:I

    .line 37
    return-void
.end method
