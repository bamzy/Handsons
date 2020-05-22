.class Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids$ConcreteDevice;
.super Ljava/lang/Object;
.source "PL2303Ids.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids;
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
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids$ConcreteDevice;->vendorId:I

    .line 90
    iput p2, p0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/PL2303Ids$ConcreteDevice;->productId:I

    .line 91
    return-void
.end method
