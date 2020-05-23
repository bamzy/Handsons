package com.drms.drms_drone.Upload;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;
import com.drms.drms_drone.Protocol.STK500v1.STK500v1;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class UploadManager {
  public static final boolean D = true;
  
  private static final int MESSAGE_READ = 3;
  
  private static final int MESSAGE_STATE_CHANGE = 7;
  
  private static final int MESSAGE_WRITE = 2;
  
  private static final int ORIENT_COMMAND = 20;
  
  private static final int RECEIVED_MESSAGE = 21;
  
  private static final int REQUEST_CONNECT_DEVICE = 1;
  
  private static final int REQUEST_ENABLE_BT = 2;
  
  private static final String TAG = "UplaodManager";
  
  private static final int UPDATE_STATE = 4;
  
  public static final int UPLOAD_END = 4;
  
  public static final int UPLOAD_FAILED = -1;
  
  private static final int UPLOAD_PROGRESS = 22;
  
  public static final int UPLOAD_START = 3;
  
  private static final int UPLOAD_STATE = 23;
  
  public static final int UPLOAD_SUCCESS = 1;
  
  private int BT_Connecting_tries = 0;
  
  private Bitmap arrowOff;
  
  private BitmapDrawable arrowOffDrawable;
  
  private Bitmap arrowOn;
  
  private BitmapDrawable arrowOnDrawable;
  
  private String bt_address;
  
  private ArrayList<Integer> command_data;
  
  private AlertDialog dialog;
  
  private String hexData = null;
  
  private TextView information;
  
  private boolean init_state = false;
  
  private boolean isInitializing = false;
  
  private boolean isUploading = false;
  
  private Activity mActivity;
  
  private BluetoothService mBluetoothService;
  
  private StringBuffer mOutStringBuffer;
  
  private Bitmap notConnected;
  
  private BitmapDrawable notConnectedDrawable;
  
  private byte orient_command;
  
  private ProgressView progressBar;
  
  private LinearLayout progresslayout;
  
  private int request;
  
  private boolean startUpload = true;
  
  private ImageView[] state = new ImageView[3];
  
  private int stateOnIndex = 0;
  
  private STK500v1 stk500;
  
  private Handler uploadManagerHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        // Byte code:
        //   0: aload_0
        //   1: aload_1
        //   2: invokespecial handleMessage : (Landroid/os/Message;)V
        //   5: aload_1
        //   6: getfield what : I
        //   9: lookupswitch default -> 60, 3 -> 267, 4 -> 749, 7 -> 61, 20 -> 377, 23 -> 391
        //   60: return
        //   61: ldc 'UplaodManager'
        //   63: new java/lang/StringBuilder
        //   66: dup
        //   67: invokespecial <init> : ()V
        //   70: ldc 'MESSAGE_STATE_CHANGE:'
        //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   75: aload_1
        //   76: getfield arg1 : I
        //   79: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   82: invokevirtual toString : ()Ljava/lang/String;
        //   85: invokestatic i : (Ljava/lang/String;Ljava/lang/String;)I
        //   88: pop
        //   89: aload_1
        //   90: getfield arg1 : I
        //   93: lookupswitch default -> 120, 3 -> 60, 8 -> 121
        //   120: return
        //   121: ldc 'UplaodManager'
        //   123: ldc 'bluetooth disconnected'
        //   125: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
        //   128: pop
        //   129: aload_0
        //   130: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   133: invokestatic access$700 : (Lcom/drms/drms_drone/Upload/UploadManager;)Z
        //   136: ifne -> 60
        //   139: aload_0
        //   140: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   143: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   146: ifnull -> 160
        //   149: aload_0
        //   150: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   153: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   156: iconst_0
        //   157: putfield running : Z
        //   160: aload_0
        //   161: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   164: iconst_0
        //   165: invokestatic access$002 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   168: pop
        //   169: aload_0
        //   170: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   173: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   176: sipush #255
        //   179: sipush #255
        //   182: bipush #61
        //   184: bipush #95
        //   186: invokestatic argb : (IIII)I
        //   189: invokevirtual setTextColor : (I)V
        //   192: aload_0
        //   193: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   196: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   199: ldc '블루투스 연결이 끊어져 종료합니다.'
        //   201: invokevirtual setText : (Ljava/lang/CharSequence;)V
        //   204: iconst_0
        //   205: istore_3
        //   206: iload_3
        //   207: aload_0
        //   208: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   211: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   214: arraylength
        //   215: if_icmpge -> 244
        //   218: aload_0
        //   219: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   222: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   225: iload_3
        //   226: aaload
        //   227: aload_0
        //   228: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   231: invokestatic access$1500 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
        //   234: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
        //   237: iload_3
        //   238: iconst_1
        //   239: iadd
        //   240: istore_3
        //   241: goto -> 206
        //   244: aload_0
        //   245: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   248: invokestatic access$500 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/os/Handler;
        //   251: new com/drms/drms_drone/Upload/UploadManager$8$1
        //   254: dup
        //   255: aload_0
        //   256: invokespecial <init> : (Lcom/drms/drms_drone/Upload/UploadManager$8;)V
        //   259: ldc2_w 2000
        //   262: invokevirtual postDelayed : (Ljava/lang/Runnable;J)Z
        //   265: pop
        //   266: return
        //   267: aload_1
        //   268: getfield obj : Ljava/lang/Object;
        //   271: checkcast [B
        //   274: checkcast [B
        //   277: astore_1
        //   278: ldc 'UplaodManager'
        //   280: new java/lang/StringBuilder
        //   283: dup
        //   284: invokespecial <init> : ()V
        //   287: ldc 'stk500 : '
        //   289: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   292: aload_0
        //   293: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   296: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   299: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
        //   302: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   305: invokevirtual toString : ()Ljava/lang/String;
        //   308: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   311: pop
        //   312: ldc 'UplaodManager'
        //   314: new java/lang/StringBuilder
        //   317: dup
        //   318: invokespecial <init> : ()V
        //   321: ldc 'stkHandler : '
        //   323: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   326: aload_0
        //   327: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   330: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   333: invokevirtual getStk500_handler : ()Landroid/os/Handler;
        //   336: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
        //   339: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   342: invokevirtual toString : ()Ljava/lang/String;
        //   345: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   348: pop
        //   349: aload_0
        //   350: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   353: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   356: invokevirtual getStk500_handler : ()Landroid/os/Handler;
        //   359: bipush #21
        //   361: aload_0
        //   362: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   365: invokestatic access$1600 : (Lcom/drms/drms_drone/Upload/UploadManager;)B
        //   368: iconst_m1
        //   369: aload_1
        //   370: invokevirtual obtainMessage : (IIILjava/lang/Object;)Landroid/os/Message;
        //   373: invokevirtual sendToTarget : ()V
        //   376: return
        //   377: aload_0
        //   378: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   381: aload_1
        //   382: getfield arg1 : I
        //   385: i2b
        //   386: invokestatic access$1602 : (Lcom/drms/drms_drone/Upload/UploadManager;B)B
        //   389: pop
        //   390: return
        //   391: aload_1
        //   392: getfield arg1 : I
        //   395: tableswitch default -> 432, -1 -> 655, 0 -> 432, 1 -> 568, 2 -> 665, 3 -> 682, 4 -> 736
        //   432: aload_0
        //   433: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   436: invokestatic access$1800 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Communication/ClassicBluetooth/BluetoothService;
        //   439: invokevirtual getState : ()I
        //   442: iconst_4
        //   443: if_icmpne -> 60
        //   446: aload_0
        //   447: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   450: invokestatic access$000 : (Lcom/drms/drms_drone/Upload/UploadManager;)Z
        //   453: ifne -> 481
        //   456: aload_0
        //   457: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   460: iconst_0
        //   461: invokestatic access$902 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   464: pop
        //   465: aload_0
        //   466: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   469: iconst_1
        //   470: invokestatic access$002 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   473: pop
        //   474: aload_0
        //   475: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   478: invokestatic access$1900 : (Lcom/drms/drms_drone/Upload/UploadManager;)V
        //   481: aload_1
        //   482: getfield arg1 : I
        //   485: bipush #100
        //   487: imul
        //   488: aload_1
        //   489: getfield arg2 : I
        //   492: idiv
        //   493: istore_3
        //   494: aload_1
        //   495: getfield arg1 : I
        //   498: i2f
        //   499: ldc 1000.0
        //   501: fdiv
        //   502: fstore_2
        //   503: aload_1
        //   504: getfield arg2 : I
        //   507: i2f
        //   508: ldc 1000.0
        //   510: fdiv
        //   511: fstore_2
        //   512: aload_0
        //   513: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   516: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   519: new java/lang/StringBuilder
        //   522: dup
        //   523: invokespecial <init> : ()V
        //   526: ldc '업로드 중... ( '
        //   528: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   531: iload_3
        //   532: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   535: ldc ' % 완료 )'
        //   537: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   540: invokevirtual toString : ()Ljava/lang/String;
        //   543: invokevirtual setText : (Ljava/lang/CharSequence;)V
        //   546: aload_0
        //   547: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   550: invokestatic access$2000 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;
        //   553: iload_3
        //   554: invokevirtual setProgress : (I)V
        //   557: aload_0
        //   558: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   561: invokestatic access$2000 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Upload/UploadManager$ProgressView;
        //   564: invokevirtual invalidate : ()V
        //   567: return
        //   568: aload_0
        //   569: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   572: iconst_0
        //   573: invokestatic access$002 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   576: pop
        //   577: aload_0
        //   578: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   581: iconst_0
        //   582: invokestatic access$302 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   585: pop
        //   586: ldc2_w 500
        //   589: invokestatic sleep : (J)V
        //   592: aload_0
        //   593: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   596: invokestatic access$200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Lcom/drms/drms_drone/Protocol/STK500v1/STK500v1;
        //   599: iconst_0
        //   600: putfield running : Z
        //   603: aload_0
        //   604: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   607: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   610: ldc '업로드가 완료 되었습니다.'
        //   612: invokevirtual setText : (Ljava/lang/CharSequence;)V
        //   615: iconst_0
        //   616: istore_3
        //   617: iload_3
        //   618: aload_0
        //   619: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   622: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   625: arraylength
        //   626: if_icmpge -> 60
        //   629: aload_0
        //   630: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   633: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   636: iload_3
        //   637: aaload
        //   638: aload_0
        //   639: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   642: invokestatic access$1500 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
        //   645: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
        //   648: iload_3
        //   649: iconst_1
        //   650: iadd
        //   651: istore_3
        //   652: goto -> 617
        //   655: aload_0
        //   656: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   659: iconst_0
        //   660: invokestatic access$002 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   663: pop
        //   664: return
        //   665: ldc 'UplaodManager'
        //   667: ldc 'Try Again to Upload'
        //   669: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   672: pop
        //   673: aload_0
        //   674: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   677: invokestatic access$600 : (Lcom/drms/drms_drone/Upload/UploadManager;)Z
        //   680: pop
        //   681: return
        //   682: aload_0
        //   683: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   686: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   689: aload_0
        //   690: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   693: invokestatic access$100 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/app/Activity;
        //   696: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   699: ldc 2131492907
        //   701: invokevirtual getColor : (I)I
        //   704: invokevirtual setTextColor : (I)V
        //   707: aload_0
        //   708: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   711: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   714: ldc 'initializing...'
        //   716: invokevirtual setText : (Ljava/lang/CharSequence;)V
        //   719: aload_0
        //   720: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   723: iconst_1
        //   724: invokestatic access$902 : (Lcom/drms/drms_drone/Upload/UploadManager;Z)Z
        //   727: pop
        //   728: aload_0
        //   729: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   732: invokestatic access$1700 : (Lcom/drms/drms_drone/Upload/UploadManager;)V
        //   735: return
        //   736: aload_0
        //   737: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   740: invokestatic access$1400 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/widget/TextView;
        //   743: ldc '업로드 종료 요청 중입니다.'
        //   745: invokevirtual setText : (Ljava/lang/CharSequence;)V
        //   748: return
        //   749: ldc 'UplaodManager'
        //   751: new java/lang/StringBuilder
        //   754: dup
        //   755: invokespecial <init> : ()V
        //   758: ldc 'state on : '
        //   760: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   763: aload_1
        //   764: getfield arg1 : I
        //   767: invokevirtual append : (I)Ljava/lang/StringBuilder;
        //   770: invokevirtual toString : ()Ljava/lang/String;
        //   773: invokestatic d : (Ljava/lang/String;Ljava/lang/String;)I
        //   776: pop
        //   777: iconst_0
        //   778: istore_3
        //   779: iload_3
        //   780: aload_0
        //   781: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   784: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   787: arraylength
        //   788: if_icmpge -> 817
        //   791: aload_0
        //   792: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   795: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   798: iload_3
        //   799: aaload
        //   800: aload_0
        //   801: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   804: invokestatic access$1200 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
        //   807: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
        //   810: iload_3
        //   811: iconst_1
        //   812: iadd
        //   813: istore_3
        //   814: goto -> 779
        //   817: aload_0
        //   818: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   821: invokestatic access$1100 : (Lcom/drms/drms_drone/Upload/UploadManager;)[Landroid/widget/ImageView;
        //   824: aload_1
        //   825: getfield arg1 : I
        //   828: aaload
        //   829: aload_0
        //   830: getfield this$0 : Lcom/drms/drms_drone/Upload/UploadManager;
        //   833: invokestatic access$1300 : (Lcom/drms/drms_drone/Upload/UploadManager;)Landroid/graphics/drawable/BitmapDrawable;
        //   836: invokevirtual setImageDrawable : (Landroid/graphics/drawable/Drawable;)V
        //   839: return
        //   840: astore_1
        //   841: goto -> 592
        // Exception table:
        //   from	to	target	type
        //   586	592	840	java/lang/InterruptedException
      }
    };
  
  private boolean uploadSuccess = false;
  
  private AlertDialog.Builder upload_dialog;
  
  public UploadManager(Activity paramActivity, BluetoothService paramBluetoothService, String paramString, int paramInt) {
    this.mActivity = paramActivity;
    this.bt_address = paramString;
    this.mBluetoothService = paramBluetoothService;
    this.mBluetoothService.setmHandler(this.uploadManagerHandler);
    this.request = paramInt;
    this.stk500 = new STK500v1(paramActivity, paramBluetoothService, this.uploadManagerHandler, paramInt);
    Paint paint = new Paint();
    paint.setColor(paramActivity.getResources().getColor(2131492937));
    paint.setStrokeWidth(20.0F);
    paint = new Paint();
    paint.setColor(-7829368);
    paint.setStrokeWidth(20.0F);
    paint = new Paint();
    paint.setColor(-16777216);
    paint.setStrokeWidth(20.0F);
    Bitmap bitmap2 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130903071);
    this.notConnectedDrawable = new BitmapDrawable(Bitmap.createScaledBitmap(BitmapFactory.decodeResource(paramActivity.getResources(), 2130903052), bitmap2.getWidth(), bitmap2.getHeight(), true));
    Bitmap bitmap3 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130903071);
    Bitmap bitmap1 = BitmapFactory.decodeResource(paramActivity.getResources(), 2130903084);
    bitmap3 = Bitmap.createScaledBitmap(bitmap3, bitmap2.getWidth(), bitmap2.getHeight(), true);
    this.arrowOnDrawable = new BitmapDrawable(Bitmap.createScaledBitmap(bitmap1, bitmap2.getWidth(), bitmap2.getHeight(), true));
    this.arrowOffDrawable = new BitmapDrawable(bitmap3);
    this.hexData = makeHexStringFromHexFile();
    requestUploadDialog();
    Log.d("UplaodManager", String.valueOf(paramBluetoothService.getState()));
    Log.d("UplaodManager", "Firm ware \n " + this.hexData);
  }
  
  private void displayStateOfUpload() {
    (new Thread(new Runnable() {
          public void run() {
            while (UploadManager.this.isUploading) {
              UploadManager.this.uploadManagerHandler.obtainMessage(4, UploadManager.access$808(UploadManager.this), -1).sendToTarget();
              try {
                Thread.sleep(100L);
              } catch (InterruptedException interruptedException) {}
              if (UploadManager.this.stateOnIndex > 2)
                UploadManager.access$802(UploadManager.this, 0); 
            } 
          }
        })).start();
  }
  
  private void display_initializing() {
    (new Thread(new Runnable() {
          public void run() {
            while (UploadManager.this.isInitializing) {
              try {
                Thread.sleep(200L);
              } catch (InterruptedException interruptedException) {}
              UploadManager.this.mActivity.runOnUiThread(new Runnable() {
                    public void run() {
                      if (UploadManager.this.init_state) {
                        UploadManager.access$1002(UploadManager.this, false);
                        for (int i = 0; i < UploadManager.this.state.length; i++)
                          UploadManager.this.state[i].setImageDrawable((Drawable)UploadManager.this.arrowOffDrawable); 
                      } else {
                        UploadManager.access$1002(UploadManager.this, true);
                        for (int i = 0; i < UploadManager.this.state.length; i++)
                          UploadManager.this.state[i].setImageDrawable((Drawable)UploadManager.this.arrowOnDrawable); 
                      } 
                    }
                  });
            } 
          }
        })).start();
  }
  
  private String makeHexStringFromHexFile() {
    StringBuffer stringBuffer;
    byte[] arrayOfByte;
    InputStream inputStream = null;
    switch (this.request) {
      default:
        stringBuffer = new StringBuffer();
        arrayOfByte = new byte[1024];
        try {
          while (true) {
            int i = inputStream.read(arrayOfByte);
            if (i != -1) {
              stringBuffer.append(new String(arrayOfByte, 0, i));
              continue;
            } 
            break;
          } 
        } catch (IOException iOException) {}
        return stringBuffer.toString().replaceAll(":", "3A").replaceAll(System.getProperty("line.separator"), "").replaceAll("\\p{Space}", "");
      case 0:
        inputStream = this.mActivity.getResources().openRawResource(2131165192);
      case 1:
        inputStream = this.mActivity.getResources().openRawResource(2131165193);
      case 2:
        inputStream = this.mActivity.getResources().openRawResource(2131165194);
      case 3:
        inputStream = this.mActivity.getResources().openRawResource(2131165189);
      case 4:
        inputStream = this.mActivity.getResources().openRawResource(2131165190);
      case 5:
        break;
    } 
    inputStream = this.mActivity.getResources().openRawResource(2131165191);
  }
  
  private byte[] requestCommand(Character[] paramArrayOfCharacter) {
    byte[] arrayOfByte = new byte[paramArrayOfCharacter.length];
    for (int i = 0; i < arrayOfByte.length; i++)
      arrayOfByte[i] = (byte)(paramArrayOfCharacter[i].charValue() & 0xFF); 
    return arrayOfByte;
  }
  
  private boolean requestUpload() {
    null = true;
    if (this.mBluetoothService != null) {
      if (this.mBluetoothService.getState() == 4) {
        this.information.setText("리셋 버튼을 눌러주세요.");
        Log.d("UplaodManager", "make stk500 instance");
        final byte[] binaryFile = new byte[this.hexData.length() / 2];
        for (int j = 0; j < this.hexData.length(); j += 2)
          arrayOfByte[j / 2] = Integer.decode("0x" + this.hexData.substring(j, j + 2)).byteValue(); 
        (new Thread(new Runnable() {
              public void run() {
                if (UploadManager.this.stk500 != null) {
                  UploadManager.access$702(UploadManager.this, UploadManager.this.stk500.programHexFile(binaryFile, 256, true));
                  if (UploadManager.this.uploadSuccess) {
                    Log.d("UplaodManager", "Uploading Successful");
                    UploadManager.access$002(UploadManager.this, false);
                    UploadManager.this.uploadManagerHandler.obtainMessage(23, 1, -1).sendToTarget();
                    return;
                  } 
                  Log.e("UplaodManager", "Failed to Uploading");
                  return;
                } 
                Log.e("UplaodManager", "STK500 instance is null");
              }
            })).start();
        return null;
      } 
      Log.e("UplaodManager", "bluetooth communication is not connected");
      this.isUploading = false;
      for (int i = 0; i < this.state.length; i++)
        this.state[i].setImageDrawable((Drawable)this.notConnectedDrawable); 
      this.information.setTextColor(Color.argb(255, 255, 61, 95));
      this.information.setText("블루투스 연결이 끊어졌습니다.");
      try {
        Thread.sleep(1000L);
      } catch (InterruptedException interruptedException) {}
      this.dialog.dismiss();
      return false;
    } 
    return false;
  }
  
  private void requestUploadDialog() {
    this.upload_dialog = new AlertDialog.Builder((Context)this.mActivity);
    this.mActivity.getWindow().getDecorView().setSystemUiVisibility(4098);
    ConstraintLayout constraintLayout = (ConstraintLayout)View.inflate((Context)this.mActivity, 2130968607, null);
    this.upload_dialog.setCancelable(false);
    this.upload_dialog.setNegativeButton("닫기", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            if (!UploadManager.this.isUploading) {
              param1DialogInterface.dismiss();
              return;
            } 
            Toast.makeText((Context)UploadManager.this.mActivity, "업로드 중에는 종료할 수 없습니다.", 0).show();
          }
        });
    this.state[0] = (ImageView)constraintLayout.findViewById(2131558511);
    this.state[1] = (ImageView)constraintLayout.findViewById(2131558510);
    this.state[2] = (ImageView)constraintLayout.findViewById(2131558514);
    for (int i = 0; i < this.state.length; i++)
      this.state[i].setImageDrawable((Drawable)this.notConnectedDrawable); 
    this.information = (TextView)constraintLayout.findViewById(2131558513);
    this.information.setText("업로드를 준비 중 입니다.");
    this.progresslayout = (LinearLayout)constraintLayout.findViewById(2131558515);
    this.progressBar = new ProgressView((Context)this.mActivity);
    this.progressBar.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    this.progresslayout.addView(this.progressBar);
    this.progressBar.invalidate();
    this.upload_dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
          public void onDismiss(DialogInterface param1DialogInterface) {
            if (UploadManager.this.stk500 != null) {
              UploadManager.this.stk500.running = false;
              UploadManager.access$202(UploadManager.this, null);
            } 
            UploadManager.this.mActivity.setResult(1);
            UploadManager.this.mActivity.finish();
          }
        });
    this.upload_dialog.setView((View)constraintLayout);
    this.dialog = this.upload_dialog.create();
    this.dialog.show();
    (new Thread(new Runnable() {
          public void run() {
            while (UploadManager.this.startUpload) {
              try {
                Thread.sleep(100L);
              } catch (InterruptedException interruptedException) {}
            } 
            UploadManager.this.uploadManagerHandler.postDelayed(new Runnable() {
                  public void run() {
                    UploadManager.this.mActivity.runOnUiThread(new Runnable() {
                          public void run() {
                            UploadManager.this.dialog.dismiss();
                          }
                        },  );
                  }
                },  2000L);
          }
        })).start();
    this.uploadManagerHandler.postDelayed(new Runnable() {
          public void run() {
            UploadManager.this.requestUpload();
          }
        },  1500L);
  }
  
  public class ProgressView extends View {
    private float droneLocation = 0.0F;
    
    private Paint executedPaint;
    
    private Paint non_execuetPaint = new Paint();
    
    private int progress;
    
    private Bitmap progressDrone;
    
    public ProgressView(Context param1Context) {
      super(param1Context);
      this.non_execuetPaint.setStrokeWidth(30.0F);
      this.non_execuetPaint.setColor(-7829368);
      this.executedPaint = new Paint();
      this.executedPaint.setStrokeWidth(30.0F);
      this.executedPaint.setColor(UploadManager.this.mActivity.getResources().getColor(2131492936));
      this.progressDrone = BitmapFactory.decodeResource(UploadManager.this.mActivity.getResources(), 2130837593);
      this.droneLocation = 0.0F;
    }
    
    protected void onDraw(Canvas param1Canvas) {
      super.onDraw(param1Canvas);
      Log.d("UplaodManager", "progress : " + this.progress);
      float f1 = (param1Canvas.getWidth() - this.progressDrone.getWidth() * 2);
      this.droneLocation = (this.progressDrone.getWidth() / 2) + this.progress * f1 / 100.0F;
      f1 = this.progressDrone.getWidth();
      float f2 = (param1Canvas.getHeight() / 2);
      float f3 = this.droneLocation;
      param1Canvas.drawLine(f1, f2, (this.progressDrone.getWidth() / 2) + f3, (param1Canvas.getHeight() / 2), this.executedPaint);
      f1 = this.droneLocation;
      param1Canvas.drawLine((this.progressDrone.getWidth() / 2) + f1, (param1Canvas.getHeight() / 2), (param1Canvas.getWidth() - this.progressDrone.getWidth()), (param1Canvas.getHeight() / 2), this.non_execuetPaint);
      param1Canvas.drawBitmap(this.progressDrone, this.droneLocation, (param1Canvas.getHeight() / 2 - this.progressDrone.getHeight() / 2), null);
    }
    
    public void setProgress(int param1Int) {
      this.progress = param1Int;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Upload\UploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */