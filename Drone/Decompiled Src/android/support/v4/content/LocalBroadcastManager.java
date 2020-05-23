package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

public final class LocalBroadcastManager {
  private static final boolean DEBUG = false;
  
  static final int MSG_EXEC_PENDING_BROADCASTS = 1;
  
  private static final String TAG = "LocalBroadcastManager";
  
  private static LocalBroadcastManager mInstance;
  
  private static final Object mLock = new Object();
  
  private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<String, ArrayList<ReceiverRecord>>();
  
  private final Context mAppContext;
  
  private final Handler mHandler;
  
  private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<BroadcastRecord>();
  
  private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<BroadcastReceiver, ArrayList<IntentFilter>>();
  
  private LocalBroadcastManager(Context paramContext) {
    this.mAppContext = paramContext;
    this.mHandler = new Handler(paramContext.getMainLooper()) {
        public void handleMessage(Message param1Message) {
          switch (param1Message.what) {
            default:
              super.handleMessage(param1Message);
              return;
            case 1:
              break;
          } 
          LocalBroadcastManager.this.executePendingBroadcasts();
        }
      };
  }
  
  private void executePendingBroadcasts() {
    while (true) {
      HashMap<BroadcastReceiver, ArrayList<IntentFilter>> hashMap;
      BroadcastRecord broadcastRecord;
      synchronized (this.mReceivers) {
        int i = this.mPendingBroadcasts.size();
        if (i <= 0)
          return; 
        BroadcastRecord[] arrayOfBroadcastRecord = new BroadcastRecord[i];
        this.mPendingBroadcasts.toArray(arrayOfBroadcastRecord);
        this.mPendingBroadcasts.clear();
        for (i = 0; i < arrayOfBroadcastRecord.length; i++) {
          broadcastRecord = arrayOfBroadcastRecord[i];
          for (int j = 0; j < broadcastRecord.receivers.size(); j++)
            ((ReceiverRecord)broadcastRecord.receivers.get(j)).receiver.onReceive(this.mAppContext, broadcastRecord.intent); 
        } 
      } 
    } 
  }
  
  public static LocalBroadcastManager getInstance(Context paramContext) {
    synchronized (mLock) {
      if (mInstance == null)
        mInstance = new LocalBroadcastManager(paramContext.getApplicationContext()); 
      return mInstance;
    } 
  }
  
  public void registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter) {
    synchronized (this.mReceivers) {
      ReceiverRecord receiverRecord = new ReceiverRecord(paramIntentFilter, paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList2 = this.mReceivers.get(paramBroadcastReceiver);
      ArrayList<IntentFilter> arrayList1 = arrayList2;
      if (arrayList2 == null) {
        arrayList1 = new ArrayList(1);
        this.mReceivers.put(paramBroadcastReceiver, arrayList1);
      } 
      arrayList1.add(paramIntentFilter);
      for (int i = 0; i < paramIntentFilter.countActions(); i++) {
        String str = paramIntentFilter.getAction(i);
        arrayList1 = (ArrayList<IntentFilter>)this.mActions.get(str);
        ArrayList<IntentFilter> arrayList = arrayList1;
        if (arrayList1 == null) {
          arrayList = new ArrayList<IntentFilter>(1);
          this.mActions.put(str, arrayList);
        } 
        arrayList.add(receiverRecord);
      } 
      return;
    } 
  }
  
  public boolean sendBroadcast(Intent paramIntent) {
    // Byte code:
    //   0: aload_0
    //   1: getfield mReceivers : Ljava/util/HashMap;
    //   4: astore #7
    //   6: aload #7
    //   8: monitorenter
    //   9: aload_1
    //   10: invokevirtual getAction : ()Ljava/lang/String;
    //   13: astore #8
    //   15: aload_1
    //   16: aload_0
    //   17: getfield mAppContext : Landroid/content/Context;
    //   20: invokevirtual getContentResolver : ()Landroid/content/ContentResolver;
    //   23: invokevirtual resolveTypeIfNeeded : (Landroid/content/ContentResolver;)Ljava/lang/String;
    //   26: astore #9
    //   28: aload_1
    //   29: invokevirtual getData : ()Landroid/net/Uri;
    //   32: astore #10
    //   34: aload_1
    //   35: invokevirtual getScheme : ()Ljava/lang/String;
    //   38: astore #11
    //   40: aload_1
    //   41: invokevirtual getCategories : ()Ljava/util/Set;
    //   44: astore #12
    //   46: aload_1
    //   47: invokevirtual getFlags : ()I
    //   50: bipush #8
    //   52: iand
    //   53: ifeq -> 521
    //   56: iconst_1
    //   57: istore_2
    //   58: iload_2
    //   59: ifeq -> 107
    //   62: ldc 'LocalBroadcastManager'
    //   64: new java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial <init> : ()V
    //   71: ldc 'Resolving type '
    //   73: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: aload #9
    //   78: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc ' scheme '
    //   83: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload #11
    //   88: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: ldc ' of intent '
    //   93: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   100: invokevirtual toString : ()Ljava/lang/String;
    //   103: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: aload_0
    //   108: getfield mActions : Ljava/util/HashMap;
    //   111: aload_1
    //   112: invokevirtual getAction : ()Ljava/lang/String;
    //   115: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   118: checkcast java/util/ArrayList
    //   121: astore #13
    //   123: aload #13
    //   125: ifnull -> 497
    //   128: iload_2
    //   129: ifeq -> 502
    //   132: ldc 'LocalBroadcastManager'
    //   134: new java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial <init> : ()V
    //   141: ldc 'Action list: '
    //   143: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload #13
    //   148: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   157: pop
    //   158: goto -> 502
    //   161: iload_3
    //   162: aload #13
    //   164: invokevirtual size : ()I
    //   167: if_icmpge -> 554
    //   170: aload #13
    //   172: iload_3
    //   173: invokevirtual get : (I)Ljava/lang/Object;
    //   176: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
    //   179: astore #14
    //   181: iload_2
    //   182: ifeq -> 214
    //   185: ldc 'LocalBroadcastManager'
    //   187: new java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial <init> : ()V
    //   194: ldc 'Matching against filter '
    //   196: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: aload #14
    //   201: getfield filter : Landroid/content/IntentFilter;
    //   204: invokevirtual append : (Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: invokevirtual toString : ()Ljava/lang/String;
    //   210: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   213: pop
    //   214: aload #14
    //   216: getfield broadcasting : Z
    //   219: ifeq -> 245
    //   222: aload #6
    //   224: astore #5
    //   226: iload_2
    //   227: ifeq -> 510
    //   230: ldc 'LocalBroadcastManager'
    //   232: ldc '  Filter's target already added'
    //   234: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   237: pop
    //   238: aload #6
    //   240: astore #5
    //   242: goto -> 510
    //   245: aload #14
    //   247: getfield filter : Landroid/content/IntentFilter;
    //   250: aload #8
    //   252: aload #9
    //   254: aload #11
    //   256: aload #10
    //   258: aload #12
    //   260: ldc 'LocalBroadcastManager'
    //   262: invokevirtual match : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Set;Ljava/lang/String;)I
    //   265: istore #4
    //   267: iload #4
    //   269: iflt -> 346
    //   272: iload_2
    //   273: ifeq -> 305
    //   276: ldc 'LocalBroadcastManager'
    //   278: new java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial <init> : ()V
    //   285: ldc '  Filter matched!  match=0x'
    //   287: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: iload #4
    //   292: invokestatic toHexString : (I)Ljava/lang/String;
    //   295: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual toString : ()Ljava/lang/String;
    //   301: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   304: pop
    //   305: aload #6
    //   307: astore #5
    //   309: aload #6
    //   311: ifnonnull -> 323
    //   314: new java/util/ArrayList
    //   317: dup
    //   318: invokespecial <init> : ()V
    //   321: astore #5
    //   323: aload #5
    //   325: aload #14
    //   327: invokevirtual add : (Ljava/lang/Object;)Z
    //   330: pop
    //   331: aload #14
    //   333: iconst_1
    //   334: putfield broadcasting : Z
    //   337: goto -> 510
    //   340: astore_1
    //   341: aload #7
    //   343: monitorexit
    //   344: aload_1
    //   345: athrow
    //   346: aload #6
    //   348: astore #5
    //   350: iload_2
    //   351: ifeq -> 510
    //   354: iload #4
    //   356: tableswitch default -> 388, -4 -> 533, -3 -> 526, -2 -> 540, -1 -> 547
    //   388: ldc 'unknown reason'
    //   390: astore #5
    //   392: ldc 'LocalBroadcastManager'
    //   394: new java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial <init> : ()V
    //   401: ldc '  Filter did not match: '
    //   403: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload #5
    //   408: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual toString : ()Ljava/lang/String;
    //   414: invokestatic v : (Ljava/lang/String;Ljava/lang/String;)I
    //   417: pop
    //   418: aload #6
    //   420: astore #5
    //   422: goto -> 510
    //   425: iload_2
    //   426: aload #6
    //   428: invokevirtual size : ()I
    //   431: if_icmpge -> 454
    //   434: aload #6
    //   436: iload_2
    //   437: invokevirtual get : (I)Ljava/lang/Object;
    //   440: checkcast android/support/v4/content/LocalBroadcastManager$ReceiverRecord
    //   443: iconst_0
    //   444: putfield broadcasting : Z
    //   447: iload_2
    //   448: iconst_1
    //   449: iadd
    //   450: istore_2
    //   451: goto -> 425
    //   454: aload_0
    //   455: getfield mPendingBroadcasts : Ljava/util/ArrayList;
    //   458: new android/support/v4/content/LocalBroadcastManager$BroadcastRecord
    //   461: dup
    //   462: aload_1
    //   463: aload #6
    //   465: invokespecial <init> : (Landroid/content/Intent;Ljava/util/ArrayList;)V
    //   468: invokevirtual add : (Ljava/lang/Object;)Z
    //   471: pop
    //   472: aload_0
    //   473: getfield mHandler : Landroid/os/Handler;
    //   476: iconst_1
    //   477: invokevirtual hasMessages : (I)Z
    //   480: ifne -> 492
    //   483: aload_0
    //   484: getfield mHandler : Landroid/os/Handler;
    //   487: iconst_1
    //   488: invokevirtual sendEmptyMessage : (I)Z
    //   491: pop
    //   492: aload #7
    //   494: monitorexit
    //   495: iconst_1
    //   496: ireturn
    //   497: aload #7
    //   499: monitorexit
    //   500: iconst_0
    //   501: ireturn
    //   502: aconst_null
    //   503: astore #6
    //   505: iconst_0
    //   506: istore_3
    //   507: goto -> 161
    //   510: iload_3
    //   511: iconst_1
    //   512: iadd
    //   513: istore_3
    //   514: aload #5
    //   516: astore #6
    //   518: goto -> 161
    //   521: iconst_0
    //   522: istore_2
    //   523: goto -> 58
    //   526: ldc 'action'
    //   528: astore #5
    //   530: goto -> 392
    //   533: ldc 'category'
    //   535: astore #5
    //   537: goto -> 392
    //   540: ldc 'data'
    //   542: astore #5
    //   544: goto -> 392
    //   547: ldc 'type'
    //   549: astore #5
    //   551: goto -> 392
    //   554: aload #6
    //   556: ifnull -> 497
    //   559: iconst_0
    //   560: istore_2
    //   561: goto -> 425
    // Exception table:
    //   from	to	target	type
    //   9	56	340	finally
    //   62	107	340	finally
    //   107	123	340	finally
    //   132	158	340	finally
    //   161	181	340	finally
    //   185	214	340	finally
    //   214	222	340	finally
    //   230	238	340	finally
    //   245	267	340	finally
    //   276	305	340	finally
    //   314	323	340	finally
    //   323	337	340	finally
    //   341	344	340	finally
    //   392	418	340	finally
    //   425	447	340	finally
    //   454	492	340	finally
    //   492	495	340	finally
    //   497	500	340	finally
  }
  
  public void sendBroadcastSync(Intent paramIntent) {
    if (sendBroadcast(paramIntent))
      executePendingBroadcasts(); 
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver) {
    ArrayList<IntentFilter> arrayList;
    synchronized (this.mReceivers) {
      arrayList = this.mReceivers.remove(paramBroadcastReceiver);
      if (arrayList == null)
        return; 
    } 
    for (int i = 0;; i++) {
      if (i < arrayList.size()) {
        IntentFilter intentFilter = arrayList.get(i);
        int j;
        for (j = 0; j < intentFilter.countActions(); j++) {
          String str = intentFilter.getAction(j);
          ArrayList arrayList1 = this.mActions.get(str);
          if (arrayList1 != null)
            for (int k = 0;; k = m + 1) {
              int m;
              if (k < arrayList1.size()) {
                m = k;
                if (((ReceiverRecord)arrayList1.get(k)).receiver == paramBroadcastReceiver) {
                  arrayList1.remove(k);
                  m = k - 1;
                } 
              } else {
                if (arrayList1.size() <= 0)
                  this.mActions.remove(str); 
                break;
              } 
            }  
        } 
      } else {
        /* monitor exit ClassFileLocalVariableReferenceExpression{type=ObjectType{java/lang/Object}, name=SYNTHETIC_LOCAL_VARIABLE_6} */
        return;
      } 
    } 
  }
  
  private static class BroadcastRecord {
    final Intent intent;
    
    final ArrayList<LocalBroadcastManager.ReceiverRecord> receivers;
    
    BroadcastRecord(Intent param1Intent, ArrayList<LocalBroadcastManager.ReceiverRecord> param1ArrayList) {
      this.intent = param1Intent;
      this.receivers = param1ArrayList;
    }
  }
  
  private static class ReceiverRecord {
    boolean broadcasting;
    
    final IntentFilter filter;
    
    final BroadcastReceiver receiver;
    
    ReceiverRecord(IntentFilter param1IntentFilter, BroadcastReceiver param1BroadcastReceiver) {
      this.filter = param1IntentFilter;
      this.receiver = param1BroadcastReceiver;
    }
    
    public String toString() {
      StringBuilder stringBuilder = new StringBuilder(128);
      stringBuilder.append("Receiver{");
      stringBuilder.append(this.receiver);
      stringBuilder.append(" filter=");
      stringBuilder.append(this.filter);
      stringBuilder.append("}");
      return stringBuilder.toString();
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\content\LocalBroadcastManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */