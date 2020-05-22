.class public Lcom/drms/drms_drone/Protocol/STK500v1/Hex;
.super Ljava/lang/Object;
.source "Hex.java"


# instance fields
.field private binList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Byte;",
            ">;>;"
        }
    .end annotation
.end field

.field private dataList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Byte;",
            ">;"
        }
    .end annotation
.end field

.field private state:Z

.field private subHex:[B


# direct methods
.method public constructor <init>([B)V
    .locals 1
    .param p1, "bin"    # [B

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->binList:Ljava/util/ArrayList;

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->state:Z

    .line 39
    iput-object p1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    .line 42
    invoke-direct {p0}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->splitHex()Z

    move-result v0

    iput-boolean v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->state:Z

    .line 44
    return-void
.end method

.method public static bytesToHex([B)Ljava/lang/String;
    .locals 6
    .param p0, "bytes"    # [B

    .prologue
    .line 253
    const/16 v4, 0x10

    new-array v0, v4, [C

    fill-array-data v0, :array_0

    .line 255
    .local v0, "hexArray":[C
    array-length v4, p0

    mul-int/lit8 v4, v4, 0x5

    new-array v1, v4, [C

    .line 257
    .local v1, "hexChars":[C
    const/4 v2, 0x0

    .local v2, "j":I
    :goto_0
    array-length v4, p0

    if-ge v2, v4, :cond_0

    .line 258
    aget-byte v4, p0, v2

    and-int/lit16 v3, v4, 0xff

    .line 259
    .local v3, "v":I
    mul-int/lit8 v4, v2, 0x5

    const/16 v5, 0x5b

    aput-char v5, v1, v4

    .line 260
    mul-int/lit8 v4, v2, 0x5

    add-int/lit8 v4, v4, 0x1

    ushr-int/lit8 v5, v3, 0x4

    aget-char v5, v0, v5

    aput-char v5, v1, v4

    .line 261
    mul-int/lit8 v4, v2, 0x5

    add-int/lit8 v4, v4, 0x2

    and-int/lit8 v5, v3, 0xf

    aget-char v5, v0, v5

    aput-char v5, v1, v4

    .line 262
    mul-int/lit8 v4, v2, 0x5

    add-int/lit8 v4, v4, 0x3

    const/16 v5, 0x5d

    aput-char v5, v1, v4

    .line 263
    mul-int/lit8 v4, v2, 0x5

    add-int/lit8 v4, v4, 0x4

    const/16 v5, 0x20

    aput-char v5, v1, v4

    .line 257
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 265
    .end local v3    # "v":I
    :cond_0
    new-instance v4, Ljava/lang/String;

    invoke-direct {v4, v1}, Ljava/lang/String;-><init>([C)V

    return-object v4

    .line 253
    nop

    :array_0
    .array-data 2
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
    .end array-data
.end method

.method private checkData([BI)Z
    .locals 6
    .param p1, "data"    # [B
    .param p2, "startByte"    # I

    .prologue
    .line 233
    const/4 v1, 0x0

    .line 236
    .local v1, "byteValue":I
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    array-length v4, p1

    add-int/lit8 v4, v4, -0x2

    if-ge v3, v4, :cond_0

    .line 237
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int v5, p2, v3

    add-int/lit8 v5, v5, 0x1

    aget-byte v4, v4, v5

    add-int/2addr v1, v4

    .line 236
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 240
    :cond_0
    const/16 v0, 0x100

    .line 242
    .local v0, "b":I
    sub-int v4, v0, v1

    int-to-byte v2, v4

    .line 244
    .local v2, "check":B
    and-int/lit16 v4, v2, 0xff

    int-to-byte v4, v4

    array-length v5, p1

    add-int/lit8 v5, v5, -0x1

    and-int/lit16 v5, v5, 0xff

    aget-byte v5, p1, v5

    if-ne v4, v5, :cond_1

    const/4 v4, 0x1

    :goto_1
    return v4

    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private formatHexLine(II)[B
    .locals 7
    .param p1, "startByte"    # I
    .param p2, "numberOfBytes"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IndexOutOfBoundsException;
        }
    .end annotation

    .prologue
    .line 98
    :try_start_0
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v4, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    move v0, p2

    .line 106
    .local v0, "dataLength":I
    add-int v4, p1, p2

    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-le v4, v5, :cond_0

    .line 107
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    sub-int v0, v4, p1

    .line 111
    :cond_0
    new-array v3, v0, [B

    .line 114
    .local v3, "tempArray":[B
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v0, :cond_1

    .line 115
    iget-object v4, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    add-int v5, p1, v2

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Byte;

    invoke-virtual {v4}, Ljava/lang/Byte;->byteValue()B

    move-result v4

    aput-byte v4, v3, v2

    .line 114
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 99
    .end local v0    # "dataLength":I
    .end local v2    # "i":I
    .end local v3    # "tempArray":[B
    :catch_0
    move-exception v1

    .line 100
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/IndexOutOfBoundsException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Index "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " is out of bounds!"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IndexOutOfBoundsException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 118
    .end local v1    # "e":Ljava/lang/Exception;
    .restart local v0    # "dataLength":I
    .restart local v2    # "i":I
    .restart local v3    # "tempArray":[B
    :cond_1
    return-object v3
.end method

.method public static oneByteToHex(B)Ljava/lang/String;
    .locals 3
    .param p0, "b"    # B

    .prologue
    .line 274
    const/4 v1, 0x1

    new-array v0, v1, [B

    .line 275
    .local v0, "tempB":[B
    const/4 v1, 0x0

    aput-byte p0, v0, v1

    .line 276
    new-instance v1, Ljava/lang/String;

    invoke-static {v0}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->bytesToHex([B)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    return-object v1
.end method

.method private splitHex(I)I
    .locals 9
    .param p1, "startOnDataByte"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v4, -0x1

    .line 156
    const/4 v0, 0x0

    .line 159
    .local v0, "dataLength":I
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    array-length v5, v5

    add-int/2addr v5, p1

    const/4 v6, 0x6

    if-ge v5, v6, :cond_1

    .line 218
    :cond_0
    :goto_0
    return v4

    .line 164
    :cond_1
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x1

    aget-byte v0, v5, v6

    .line 167
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    aget-byte v5, v5, p1

    const/16 v6, 0x3a

    if-ne v5, v6, :cond_0

    .line 171
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x4

    aget-byte v5, v5, v6

    if-ne v5, v8, :cond_2

    if-gtz v0, :cond_0

    .line 175
    :cond_2
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x4

    aget-byte v5, v5, v6

    if-ne v5, v8, :cond_3

    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    array-length v5, v5

    add-int v6, p1, v0

    add-int/lit8 v6, v6, 0x6

    if-gt v5, v6, :cond_0

    .line 180
    :cond_3
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x4

    aget-byte v5, v5, v6

    if-nez v5, :cond_4

    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x1

    aget-byte v5, v5, v6

    if-eqz v5, :cond_0

    .line 184
    :cond_4
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->binList:Ljava/util/ArrayList;

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 186
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x1

    aget-byte v5, v5, v6

    add-int/lit8 v5, v5, 0x6

    new-array v3, v5, [B

    .line 188
    .local v3, "tempBytes":[B
    const/4 v5, 0x0

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v7, p1, 0x1

    aget-byte v6, v6, v7

    aput-byte v6, v3, v5

    .line 189
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v6, p1, 0x2

    aget-byte v5, v5, v6

    aput-byte v5, v3, v8

    .line 190
    const/4 v5, 0x2

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v7, p1, 0x3

    aget-byte v6, v6, v7

    aput-byte v6, v3, v5

    .line 191
    const/4 v5, 0x3

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v7, p1, 0x4

    aget-byte v6, v6, v7

    aput-byte v6, v3, v5

    .line 194
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    if-ge v2, v0, :cond_5

    .line 195
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int v6, v2, p1

    add-int/lit8 v6, v6, 0x5

    aget-byte v5, v5, v6

    aput-byte v5, v3, v2

    .line 194
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 199
    :cond_5
    array-length v5, v3

    add-int/lit8 v5, v5, -0x1

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int/lit8 v7, p1, 0x5

    add-int/2addr v7, v0

    aget-byte v6, v6, v7

    aput-byte v6, v3, v5

    .line 202
    invoke-direct {p0, v3, p1}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->checkData([BI)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 206
    const/4 v2, 0x0

    :goto_2
    if-ge v2, v0, :cond_6

    .line 207
    :try_start_0
    iget-object v5, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    add-int v7, p1, v2

    add-int/lit8 v7, v7, 0x5

    aget-byte v6, v6, v7

    invoke-static {v6}, Ljava/lang/Byte;->valueOf(B)Ljava/lang/Byte;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/ArrayIndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 206
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 210
    :cond_6
    add-int v4, p1, v0

    add-int/lit8 v4, v4, 0x6

    goto/16 :goto_0

    .line 211
    :catch_0
    move-exception v1

    .line 213
    .local v1, "e":Ljava/lang/ArrayIndexOutOfBoundsException;
    goto/16 :goto_0
.end method

.method private splitHex()Z
    .locals 2

    .prologue
    .line 131
    const/4 v0, 0x0

    .line 134
    .local v0, "b":I
    :cond_0
    iget-object v1, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->subHex:[B

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 135
    invoke-direct {p0, v0}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->splitHex(I)I

    move-result v0

    .line 138
    if-gez v0, :cond_0

    const/4 v1, 0x0

    .line 141
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public getChecksumStatus()Z
    .locals 1

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->state:Z

    return v0
.end method

.method public getDataSize()I
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->dataList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getHexLine(II)[B
    .locals 3
    .param p1, "startByte"    # I
    .param p2, "numberOfBytes"    # I

    .prologue
    .line 76
    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/drms/drms_drone/Protocol/STK500v1/Hex;->formatHexLine(II)[B
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 80
    :goto_0
    return-object v1

    .line 77
    :catch_0
    move-exception v0

    .line 79
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    const/4 v2, 0x0

    new-array v1, v2, [B

    .line 80
    .local v1, "temp":[B
    goto :goto_0
.end method
