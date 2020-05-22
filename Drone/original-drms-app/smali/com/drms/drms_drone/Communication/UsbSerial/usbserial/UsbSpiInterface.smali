.class public interface abstract Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface;
.super Ljava/lang/Object;
.source "UsbSpiInterface.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;
    }
.end annotation


# static fields
.field public static final DIVIDER_128:I = 0x80

.field public static final DIVIDER_16:I = 0x10

.field public static final DIVIDER_2:I = 0x2

.field public static final DIVIDER_32:I = 0x20

.field public static final DIVIDER_4:I = 0x4

.field public static final DIVIDER_64:I = 0x40

.field public static final DIVIDER_8:I = 0x8


# virtual methods
.method public abstract closeSPI()V
.end method

.method public abstract connectSPI()Z
.end method

.method public abstract getClockDivider()I
.end method

.method public abstract getSelectedSlave()I
.end method

.method public abstract readMISO(I)V
.end method

.method public abstract selectSlave(I)V
.end method

.method public abstract setClock(I)V
.end method

.method public abstract setMISOCallback(Lcom/drms/drms_drone/Communication/UsbSerial/usbserial/UsbSpiInterface$UsbMISOCallback;)V
.end method

.method public abstract writeMOSI([B)V
.end method

.method public abstract writeRead([BI)V
.end method
