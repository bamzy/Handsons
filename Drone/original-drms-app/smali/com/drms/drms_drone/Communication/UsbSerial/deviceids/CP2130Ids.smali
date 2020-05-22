.class public Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;
.super Ljava/lang/Object;
.source "CP2130Ids.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;
    }
.end annotation


# static fields
.field private static final cp2130Devices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    .line 5
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    const/4 v1, 0x0

    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    const/16 v3, 0x10c4

    const v4, 0x87a0

    invoke-direct {v2, v3, v4}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;-><init>(II)V

    aput-object v2, v0, v1

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;->cp2130Devices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static isDeviceSupported(II)Z
    .locals 2
    .param p0, "vendorId"    # I
    .param p1, "productId"    # I

    .prologue
    .line 11
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;->cp2130Devices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    array-length v1, v1

    add-int/lit8 v1, v1, -0x1

    if-gt v0, v1, :cond_1

    .line 13
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;->cp2130Devices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    aget-object v1, v1, v0

    iget v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;->vendorId:I

    if-ne v1, p0, :cond_0

    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids;->cp2130Devices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;

    aget-object v1, v1, v0

    iget v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CP2130Ids$ConcreteDevice;->productId:I

    if-ne v1, p1, :cond_0

    .line 15
    const/4 v1, 0x1

    .line 18
    :goto_1
    return v1

    .line 11
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 18
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method
