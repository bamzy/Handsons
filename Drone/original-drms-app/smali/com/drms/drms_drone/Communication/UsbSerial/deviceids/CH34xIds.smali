.class public Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;
.super Ljava/lang/Object;
.source "CH34xIds.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;
    }
.end annotation


# static fields
.field private static final ch34xDevices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/16 v5, 0x5523

    const/16 v4, 0x1a86

    .line 10
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    const/4 v1, 0x0

    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    const/16 v3, 0x4348

    invoke-direct {v2, v3, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;-><init>(II)V

    aput-object v2, v0, v1

    const/4 v1, 0x1

    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    const/16 v3, 0x7523

    invoke-direct {v2, v4, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;-><init>(II)V

    aput-object v2, v0, v1

    const/4 v1, 0x2

    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    invoke-direct {v2, v4, v5}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;-><init>(II)V

    aput-object v2, v0, v1

    const/4 v1, 0x3

    new-instance v2, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    const/16 v3, 0x445

    invoke-direct {v2, v4, v3}, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;-><init>(II)V

    aput-object v2, v0, v1

    sput-object v0, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->ch34xDevices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    return-void
.end method

.method public static isDeviceSupported(II)Z
    .locals 2
    .param p0, "vendorId"    # I
    .param p1, "productId"    # I

    .prologue
    .line 20
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->ch34xDevices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    array-length v1, v1

    add-int/lit8 v1, v1, -0x1

    if-gt v0, v1, :cond_1

    .line 22
    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->ch34xDevices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    aget-object v1, v1, v0

    iget v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;->vendorId:I

    if-ne v1, p0, :cond_0

    sget-object v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds;->ch34xDevices:[Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;

    aget-object v1, v1, v0

    iget v1, v1, Lcom/drms/drms_drone/Communication/UsbSerial/deviceids/CH34xIds$ConcreteDevice;->productId:I

    if-ne v1, p1, :cond_0

    .line 23
    const/4 v1, 0x1

    .line 25
    :goto_1
    return v1

    .line 20
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 25
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method
