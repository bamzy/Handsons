.class public Lcom/drms/drms_drone/FileManagement/FileManagement;
.super Ljava/lang/Object;
.source "FileManagement.java"


# static fields
.field public static final FAILED_READ_DATA:I = 0x2b

.field private static final FILEMANAGEMENT:I = 0x4

.field public static final FINISHED_READ_DATA:I = 0x2a

.field public static final FINISHED_WRITE_DATA:I = 0x29

.field public static final REQUEST_OPEN_TEMP:I = 0x2d

.field public static final REQUEST_SAVE_TEMP:I = 0x2c

.field private static final TAG:Ljava/lang/String; = "FileManagement.class"


# instance fields
.field private Adapter:Lcom/drms/drms_drone/CustomAdapter/CustomAdapter1/CustomAdapter1;

.field private BTdirPath:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private filelist:[Ljava/io/File;

.field private inputStream:Ljava/io/FileInputStream;

.field private mHandler:Landroid/os/Handler;

.field private myFile:Ljava/io/File;

.field private myFile_list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private outputStream:Ljava/io/FileOutputStream;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Handler;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "mHandler"    # Landroid/os/Handler;

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile_list:Ljava/util/ArrayList;

    .line 36
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v0

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    .line 51
    iput-object p1, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->context:Landroid/content/Context;

    .line 52
    iput-object p2, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->mHandler:Landroid/os/Handler;

    .line 54
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/DRMS(fly)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    .line 56
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    .line 57
    iget-object v0, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    .line 59
    invoke-direct {p0}, Lcom/drms/drms_drone/FileManagement/FileManagement;->createBTFile()Z

    .line 60
    return-void
.end method

.method private createBTFile()Z
    .locals 5

    .prologue
    .line 64
    const/4 v2, 0x0

    .line 65
    .local v2, "success":Z
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/bluetoothAddr.txt"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "Btfile_Path":Ljava/lang/String;
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v3, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    .line 67
    iget-object v3, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-nez v3, :cond_0

    .line 69
    :try_start_0
    iget-object v3, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    const/4 v2, 0x1

    .line 77
    :cond_0
    :goto_0
    return v2

    .line 71
    :catch_0
    move-exception v1

    .line 72
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    const-string v4, "IOException"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 73
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public readBTAddress()[Ljava/lang/String;
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 109
    new-instance v5, Ljava/io/File;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "/bluetoothAddr.txt"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    .line 110
    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v6

    long-to-int v5, v6

    new-array v1, v5, [C

    .line 111
    .local v1, "addr":[C
    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 112
    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v5, v6, v8

    if-lez v5, :cond_1

    .line 113
    const-string v5, "FILE"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "bluetooth.txt exist"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    :try_start_0
    new-instance v5, Ljava/io/FileInputStream;

    iget-object v6, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-direct {v5, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    iput-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->inputStream:Ljava/io/FileInputStream;

    .line 116
    new-instance v2, Ljava/io/BufferedInputStream;

    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->inputStream:Ljava/io/FileInputStream;

    invoke-direct {v2, v5}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;)V

    .line 118
    .local v2, "bufferReader":Ljava/io/BufferedInputStream;
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    int-to-long v6, v3

    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v8

    cmp-long v5, v6, v8

    if-gez v5, :cond_0

    .line 119
    invoke-virtual {v2}, Ljava/io/BufferedInputStream;->read()I

    move-result v5

    int-to-char v5, v5

    aput-char v5, v1, v3

    .line 120
    const-string v5, "READ DATA"

    aget-char v6, v1, v3

    invoke-static {v6}, Ljava/lang/String;->valueOf(C)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 122
    :cond_0
    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->inputStream:Ljava/io/FileInputStream;

    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V

    .line 123
    invoke-virtual {v2}, Ljava/io/BufferedInputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 136
    .end local v2    # "bufferReader":Ljava/io/BufferedInputStream;
    .end local v3    # "i":I
    :goto_1
    const/4 v5, 0x2

    new-array v0, v5, [Ljava/lang/String;

    .line 137
    .local v0, "BT":[Ljava/lang/String;
    const-string v5, ""

    aput-object v5, v0, v10

    .line 138
    const-string v5, ""

    aput-object v5, v0, v11

    .line 140
    array-length v5, v1

    if-lez v5, :cond_2

    .line 141
    const/4 v4, 0x0

    .line 142
    .local v4, "index":I
    :goto_2
    aget-char v5, v1, v4

    const/16 v6, 0xa

    if-eq v5, v6, :cond_4

    .line 143
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v6, v0, v10

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-char v6, v1, v4

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v0, v10

    .line 144
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 129
    .end local v0    # "BT":[Ljava/lang/String;
    .end local v4    # "index":I
    :cond_1
    const/4 v0, 0x0

    .line 157
    :cond_2
    :goto_3
    return-object v0

    .line 133
    :cond_3
    const-string v5, "FILE"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "bluetooth.txt not exist"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 147
    .restart local v0    # "BT":[Ljava/lang/String;
    .restart local v4    # "index":I
    :cond_4
    add-int/lit8 v4, v4, 0x1

    .line 148
    :goto_4
    array-length v5, v1

    if-ge v4, v5, :cond_5

    .line 149
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    aget-object v6, v0, v11

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    aget-char v6, v1, v4

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v0, v11

    .line 148
    add-int/lit8 v4, v4, 0x1

    goto :goto_4

    .line 153
    :cond_5
    const-string v5, "FileManagement.class"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "name : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    aget-object v7, v0, v10

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\naddress : "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    aget-object v7, v0, v11

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 124
    .end local v0    # "BT":[Ljava/lang/String;
    .end local v4    # "index":I
    :catch_0
    move-exception v5

    goto/16 :goto_1
.end method

.method public writeBtAddressOnFile(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 7
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "address"    # Ljava/lang/String;

    .prologue
    .line 82
    const/4 v3, 0x0

    .line 84
    .local v3, "success":Z
    new-instance v4, Ljava/io/File;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->BTdirPath:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "/bluetoothAddr.txt"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v4, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    .line 85
    iget-object v4, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_0

    .line 86
    invoke-direct {p0}, Lcom/drms/drms_drone/FileManagement/FileManagement;->createBTFile()Z

    .line 90
    :cond_0
    :try_start_0
    new-instance v4, Ljava/io/FileOutputStream;

    iget-object v5, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->myFile:Ljava/io/File;

    invoke-direct {v4, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    iput-object v4, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->outputStream:Ljava/io/FileOutputStream;

    .line 91
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 93
    .local v0, "Bt":Ljava/lang/String;
    invoke-virtual {v0}, Ljava/lang/String;->getBytes()[B

    move-result-object v1

    .line 95
    .local v1, "address_temp":[B
    iget-object v4, p0, Lcom/drms/drms_drone/FileManagement/FileManagement;->outputStream:Ljava/io/FileOutputStream;

    invoke-virtual {v4, v1}, Ljava/io/FileOutputStream;->write([B)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 98
    const/4 v3, 0x1

    .line 104
    .end local v0    # "Bt":Ljava/lang/String;
    .end local v1    # "address_temp":[B
    :goto_0
    return v3

    .line 99
    :catch_0
    move-exception v2

    .line 100
    .local v2, "e":Ljava/io/IOException;
    const/4 v3, 0x0

    goto :goto_0
.end method
