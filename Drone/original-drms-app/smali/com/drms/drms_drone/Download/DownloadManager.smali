.class public Lcom/drms/drms_drone/Download/DownloadManager;
.super Ljava/lang/Object;
.source "DownloadManager.java"


# static fields
.field public static final REQUEST_HOWTO_USE:I = 0x64


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mContext:Landroid/content/Context;

.field private mDownloadManager:Landroid/app/DownloadManager;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/content/Context;)V
    .locals 0
    .param p1, "mActivity"    # Landroid/app/Activity;
    .param p2, "mContext"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p1, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    .line 45
    iput-object p2, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mContext:Landroid/content/Context;

    .line 48
    return-void
.end method


# virtual methods
.method public download()V
    .locals 15

    .prologue
    .line 51
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v10}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    const v11, 0x7f070004

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v3

    .line 52
    .local v3, "inputStream":Ljava/io/InputStream;
    new-instance v2, Ljava/io/File;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v11

    invoke-virtual {v11}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "/DRMS(fly)/howto.pdf"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v2, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 55
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_0

    .line 57
    :try_start_0
    invoke-virtual {v2}, Ljava/io/File;->createNewFile()Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_3

    .line 64
    :cond_0
    :goto_0
    :try_start_1
    invoke-virtual {v3}, Ljava/io/InputStream;->available()I

    move-result v10

    new-array v8, v10, [B

    .line 65
    .local v8, "temp":[B
    invoke-virtual {v3, v8}, Ljava/io/InputStream;->read([B)I

    .line 66
    invoke-virtual {v3}, Ljava/io/InputStream;->close()V

    .line 68
    new-instance v6, Ljava/io/FileOutputStream;

    invoke-direct {v6, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 69
    .local v6, "outputStream":Ljava/io/OutputStream;
    invoke-virtual {v6, v8}, Ljava/io/OutputStream;->write([B)V

    .line 70
    const-string v10, "Down"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Size : "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v2}, Ljava/io/File;->length()J

    move-result-wide v12

    invoke-virtual {v11, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    .line 74
    .end local v6    # "outputStream":Ljava/io/OutputStream;
    .end local v8    # "temp":[B
    :goto_1
    new-instance v4, Landroid/content/Intent;

    const-string v10, "android.intent.action.VIEW"

    invoke-direct {v4, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 75
    .local v4, "intent":Landroid/content/Intent;
    const/high16 v10, 0x14000000

    invoke-virtual {v4, v10}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 77
    const-string v10, "howto.pdf"

    invoke-static {v10}, Landroid/webkit/MimeTypeMap;->getFileExtensionFromUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 78
    .local v1, "extension":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/MimeTypeMap;->getSingleton()Landroid/webkit/MimeTypeMap;

    move-result-object v10

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Landroid/webkit/MimeTypeMap;->getMimeTypeFromExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 79
    .local v5, "mimeType":Ljava/lang/String;
    const-string v10, "down"

    invoke-static {v10, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 83
    sget v10, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v11, 0x18

    if-ge v10, v11, :cond_1

    .line 84
    invoke-static {v2}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v10

    invoke-virtual {v4, v10, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 86
    :try_start_2
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    const/16 v11, 0x64

    invoke-virtual {v10, v4, v11}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 87
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    new-instance v11, Landroid/content/Intent;

    const-string v12, "request_finish_service"

    invoke-direct {v11, v12}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v11}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_2
    .catch Landroid/content/ActivityNotFoundException; {:try_start_2 .. :try_end_2} :catch_1

    .line 109
    :goto_2
    return-void

    .line 71
    .end local v1    # "extension":Ljava/lang/String;
    .end local v4    # "intent":Landroid/content/Intent;
    .end local v5    # "mimeType":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Ljava/io/IOException;
    const-string v10, "Down"

    const-string v11, "IOException"

    invoke-static {v10, v11}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 88
    .end local v0    # "e":Ljava/io/IOException;
    .restart local v1    # "extension":Ljava/lang/String;
    .restart local v4    # "intent":Landroid/content/Intent;
    .restart local v5    # "mimeType":Ljava/lang/String;
    :catch_1
    move-exception v0

    .line 89
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    const-string v11, "pdf\ud30c\uc77c\uc744 \uc5f4\uc218 \uc5c6\uc2b5\ub2c8\ub2e4."

    const/4 v12, 0x0

    invoke-static {v10, v11, v12}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v10

    invoke-virtual {v10}, Landroid/widget/Toast;->show()V

    goto :goto_2

    .line 93
    .end local v0    # "e":Landroid/content/ActivityNotFoundException;
    :cond_1
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    invoke-virtual {v10}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v10

    const-string v11, "com.drms.drms_drone.provider"

    new-instance v12, Ljava/io/File;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v14

    invoke-virtual {v14}, Ljava/io/File;->getAbsoluteFile()Ljava/io/File;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "/DRMS(fly)/howto.pdf"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-direct {v12, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v10, v11, v12}, Landroid/support/v4/content/FileProvider;->getUriForFile(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;

    move-result-object v7

    .line 94
    .local v7, "pdfuri":Landroid/net/Uri;
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mContext:Landroid/content/Context;

    const-string v11, "com.drms.drms_drone.provider"

    invoke-static {v10, v11, v2}, Landroid/support/v4/content/FileProvider;->getUriForFile(Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;

    move-result-object v9

    .line 95
    .local v9, "uri":Landroid/net/Uri;
    invoke-virtual {v4, v9, v5}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 96
    const/4 v10, 0x1

    invoke-virtual {v4, v10}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 99
    :try_start_3
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    const/16 v11, 0x64

    invoke-virtual {v10, v4, v11}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 100
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    new-instance v11, Landroid/content/Intent;

    const-string v12, "request_finish_service"

    invoke-direct {v11, v12}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v11}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_3
    .catch Landroid/content/ActivityNotFoundException; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_2

    .line 102
    :catch_2
    move-exception v0

    .line 103
    .restart local v0    # "e":Landroid/content/ActivityNotFoundException;
    iget-object v10, p0, Lcom/drms/drms_drone/Download/DownloadManager;->mActivity:Landroid/app/Activity;

    const-string v11, "pdf\ud30c\uc77c\uc744 \uc5f4\uc218 \uc5c6\uc2b5\ub2c8\ub2e4."

    const/4 v12, 0x0

    invoke-static {v10, v11, v12}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v10

    invoke-virtual {v10}, Landroid/widget/Toast;->show()V

    goto :goto_2

    .line 59
    .end local v0    # "e":Landroid/content/ActivityNotFoundException;
    .end local v1    # "extension":Ljava/lang/String;
    .end local v4    # "intent":Landroid/content/Intent;
    .end local v5    # "mimeType":Ljava/lang/String;
    .end local v7    # "pdfuri":Landroid/net/Uri;
    .end local v9    # "uri":Landroid/net/Uri;
    :catch_3
    move-exception v10

    goto/16 :goto_0
.end method
