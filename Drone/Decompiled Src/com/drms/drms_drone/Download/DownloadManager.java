package com.drms.drms_drone.Download;

import android.app.Activity;
import android.content.Context;

public class DownloadManager {
  public static final int REQUEST_HOWTO_USE = 100;
  
  private Activity mActivity;
  
  private Context mContext;
  
  private android.app.DownloadManager mDownloadManager;
  
  public DownloadManager(Activity paramActivity, Context paramContext) {
    this.mActivity = paramActivity;
    this.mContext = paramContext;
  }
  
  public void download() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mActivity : Landroid/app/Activity;
    //   4: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   7: ldc 2131165188
    //   9: invokevirtual openRawResource : (I)Ljava/io/InputStream;
    //   12: astore_2
    //   13: new java/io/File
    //   16: dup
    //   17: new java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial <init> : ()V
    //   24: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   27: invokevirtual getAbsoluteFile : ()Ljava/io/File;
    //   30: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   33: ldc '/DRMS(fly)/howto.pdf'
    //   35: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual toString : ()Ljava/lang/String;
    //   41: invokespecial <init> : (Ljava/lang/String;)V
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual exists : ()Z
    //   49: ifne -> 57
    //   52: aload_1
    //   53: invokevirtual createNewFile : ()Z
    //   56: pop
    //   57: aload_2
    //   58: invokevirtual available : ()I
    //   61: newarray byte
    //   63: astore_3
    //   64: aload_2
    //   65: aload_3
    //   66: invokevirtual read : ([B)I
    //   69: pop
    //   70: aload_2
    //   71: invokevirtual close : ()V
    //   74: new java/io/FileOutputStream
    //   77: dup
    //   78: aload_1
    //   79: invokespecial <init> : (Ljava/io/File;)V
    //   82: aload_3
    //   83: invokevirtual write : ([B)V
    //   86: ldc 'Down'
    //   88: new java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial <init> : ()V
    //   95: ldc 'Size : '
    //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload_1
    //   101: invokevirtual length : ()J
    //   104: invokevirtual append : (J)Ljava/lang/StringBuilder;
    //   107: invokevirtual toString : ()Ljava/lang/String;
    //   110: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   113: pop
    //   114: new android/content/Intent
    //   117: dup
    //   118: ldc 'android.intent.action.VIEW'
    //   120: invokespecial <init> : (Ljava/lang/String;)V
    //   123: astore_2
    //   124: aload_2
    //   125: ldc 335544320
    //   127: invokevirtual setFlags : (I)Landroid/content/Intent;
    //   130: pop
    //   131: ldc 'howto.pdf'
    //   133: invokestatic getFileExtensionFromUrl : (Ljava/lang/String;)Ljava/lang/String;
    //   136: astore_3
    //   137: invokestatic getSingleton : ()Landroid/webkit/MimeTypeMap;
    //   140: aload_3
    //   141: invokevirtual toLowerCase : ()Ljava/lang/String;
    //   144: invokevirtual getMimeTypeFromExtension : (Ljava/lang/String;)Ljava/lang/String;
    //   147: astore #4
    //   149: ldc 'down'
    //   151: aload_3
    //   152: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: getstatic android/os/Build$VERSION.SDK_INT : I
    //   159: bipush #24
    //   161: if_icmpge -> 229
    //   164: aload_2
    //   165: aload_1
    //   166: invokestatic fromFile : (Ljava/io/File;)Landroid/net/Uri;
    //   169: aload #4
    //   171: invokevirtual setDataAndType : (Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   174: pop
    //   175: aload_0
    //   176: getfield mActivity : Landroid/app/Activity;
    //   179: aload_2
    //   180: bipush #100
    //   182: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   185: aload_0
    //   186: getfield mActivity : Landroid/app/Activity;
    //   189: new android/content/Intent
    //   192: dup
    //   193: ldc 'request_finish_service'
    //   195: invokespecial <init> : (Ljava/lang/String;)V
    //   198: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   201: return
    //   202: astore_2
    //   203: ldc 'Down'
    //   205: ldc 'IOException'
    //   207: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
    //   210: pop
    //   211: goto -> 114
    //   214: astore_1
    //   215: aload_0
    //   216: getfield mActivity : Landroid/app/Activity;
    //   219: ldc 'pdf파일을 열수 없습니다.'
    //   221: iconst_0
    //   222: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   225: invokevirtual show : ()V
    //   228: return
    //   229: aload_0
    //   230: getfield mActivity : Landroid/app/Activity;
    //   233: invokevirtual getApplicationContext : ()Landroid/content/Context;
    //   236: ldc 'com.drms.drms_drone.provider'
    //   238: new java/io/File
    //   241: dup
    //   242: new java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial <init> : ()V
    //   249: invokestatic getExternalStorageDirectory : ()Ljava/io/File;
    //   252: invokevirtual getAbsoluteFile : ()Ljava/io/File;
    //   255: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   258: ldc '/DRMS(fly)/howto.pdf'
    //   260: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: invokevirtual toString : ()Ljava/lang/String;
    //   266: invokespecial <init> : (Ljava/lang/String;)V
    //   269: invokestatic getUriForFile : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   272: pop
    //   273: aload_2
    //   274: aload_0
    //   275: getfield mContext : Landroid/content/Context;
    //   278: ldc 'com.drms.drms_drone.provider'
    //   280: aload_1
    //   281: invokestatic getUriForFile : (Landroid/content/Context;Ljava/lang/String;Ljava/io/File;)Landroid/net/Uri;
    //   284: aload #4
    //   286: invokevirtual setDataAndType : (Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   289: pop
    //   290: aload_2
    //   291: iconst_1
    //   292: invokevirtual addFlags : (I)Landroid/content/Intent;
    //   295: pop
    //   296: aload_0
    //   297: getfield mActivity : Landroid/app/Activity;
    //   300: aload_2
    //   301: bipush #100
    //   303: invokevirtual startActivityForResult : (Landroid/content/Intent;I)V
    //   306: aload_0
    //   307: getfield mActivity : Landroid/app/Activity;
    //   310: new android/content/Intent
    //   313: dup
    //   314: ldc 'request_finish_service'
    //   316: invokespecial <init> : (Ljava/lang/String;)V
    //   319: invokevirtual sendBroadcast : (Landroid/content/Intent;)V
    //   322: return
    //   323: astore_1
    //   324: aload_0
    //   325: getfield mActivity : Landroid/app/Activity;
    //   328: ldc 'pdf파일을 열수 없습니다.'
    //   330: iconst_0
    //   331: invokestatic makeText : (Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   334: invokevirtual show : ()V
    //   337: return
    //   338: astore_3
    //   339: goto -> 57
    // Exception table:
    //   from	to	target	type
    //   52	57	338	java/io/IOException
    //   57	114	202	java/io/IOException
    //   175	201	214	android/content/ActivityNotFoundException
    //   296	322	323	android/content/ActivityNotFoundException
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Download\DownloadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */