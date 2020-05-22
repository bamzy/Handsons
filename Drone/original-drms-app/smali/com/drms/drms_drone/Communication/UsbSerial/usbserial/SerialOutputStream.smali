.class public Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialOutputStream;
.super Ljava/io/OutputStream;
.source "SerialOutputStream.java"


# instance fields
.field protected final device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;


# direct methods
.method public constructor <init>(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;)V
    .locals 0
    .param p1, "device"    # Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/io/OutputStream;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialOutputStream;->device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    .line 12
    return-void
.end method


# virtual methods
.method public write(I)V
    .locals 4
    .param p1, "b"    # I

    .prologue
    .line 17
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialOutputStream;->device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    const/4 v1, 0x1

    new-array v1, v1, [B

    const/4 v2, 0x0

    int-to-byte v3, p1

    aput-byte v3, v1, v2

    invoke-interface {v0, v1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;->write([B)V

    .line 18
    return-void
.end method

.method public write([B)V
    .locals 1
    .param p1, "b"    # [B

    .prologue
    .line 23
    iget-object v0, p0, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/SerialOutputStream;->device:Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;

    invoke-interface {v0, p1}, Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSerialInterface;->write([B)V

    .line 24
    return-void
.end method
