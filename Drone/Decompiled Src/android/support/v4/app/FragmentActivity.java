package android.support.v4.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.util.SparseArrayCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class FragmentActivity extends BaseFragmentActivityJB implements ActivityCompat.OnRequestPermissionsResultCallback, ActivityCompatApi23.RequestPermissionsRequestCodeValidator {
  static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
  
  static final String FRAGMENTS_TAG = "android:support:fragments";
  
  static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
  
  static final int MSG_REALLY_STOPPED = 1;
  
  static final int MSG_RESUME_PENDING = 2;
  
  static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
  
  static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
  
  private static final String TAG = "FragmentActivity";
  
  boolean mCreated;
  
  final FragmentController mFragments = FragmentController.createController(new HostCallbacks());
  
  final Handler mHandler = new Handler() {
      public void handleMessage(Message param1Message) {
        switch (param1Message.what) {
          default:
            super.handleMessage(param1Message);
            return;
          case 1:
            if (FragmentActivity.this.mStopped) {
              FragmentActivity.this.doReallyStop(false);
              return;
            } 
            return;
          case 2:
            break;
        } 
        FragmentActivity.this.onResumeFragments();
        FragmentActivity.this.mFragments.execPendingActions();
      }
    };
  
  int mNextCandidateRequestIndex;
  
  boolean mOptionsMenuInvalidated;
  
  SparseArrayCompat<String> mPendingFragmentActivityResults;
  
  boolean mReallyStopped = true;
  
  boolean mRequestedPermissionsFromFragment;
  
  boolean mResumed;
  
  boolean mRetaining;
  
  boolean mStopped = true;
  
  private int allocateRequestIndex(Fragment paramFragment) {
    if (this.mPendingFragmentActivityResults.size() >= 65534)
      throw new IllegalStateException("Too many pending Fragment activity results."); 
    while (this.mPendingFragmentActivityResults.indexOfKey(this.mNextCandidateRequestIndex) >= 0)
      this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534; 
    int i = this.mNextCandidateRequestIndex;
    this.mPendingFragmentActivityResults.put(i, paramFragment.mWho);
    this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + 1) % 65534;
    return i;
  }
  
  private void dumpViewHierarchy(String paramString, PrintWriter paramPrintWriter, View paramView) {
    paramPrintWriter.print(paramString);
    if (paramView == null) {
      paramPrintWriter.println("null");
      return;
    } 
    paramPrintWriter.println(viewToString(paramView));
    if (paramView instanceof ViewGroup) {
      ViewGroup viewGroup = (ViewGroup)paramView;
      int i = viewGroup.getChildCount();
      if (i > 0) {
        paramString = paramString + "  ";
        int j = 0;
        while (true) {
          if (j < i) {
            dumpViewHierarchy(paramString, paramPrintWriter, viewGroup.getChildAt(j));
            j++;
            continue;
          } 
          return;
        } 
      } 
    } 
  }
  
  private static String viewToString(View paramView) {
    // Byte code:
    //   0: bipush #70
    //   2: istore_3
    //   3: bipush #46
    //   5: istore_2
    //   6: new java/lang/StringBuilder
    //   9: dup
    //   10: sipush #128
    //   13: invokespecial <init> : (I)V
    //   16: astore #5
    //   18: aload #5
    //   20: aload_0
    //   21: invokevirtual getClass : ()Ljava/lang/Class;
    //   24: invokevirtual getName : ()Ljava/lang/String;
    //   27: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload #5
    //   33: bipush #123
    //   35: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload #5
    //   41: aload_0
    //   42: invokestatic identityHashCode : (Ljava/lang/Object;)I
    //   45: invokestatic toHexString : (I)Ljava/lang/String;
    //   48: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload #5
    //   54: bipush #32
    //   56: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_0
    //   61: invokevirtual getVisibility : ()I
    //   64: lookupswitch default -> 100, 0 -> 526, 4 -> 537, 8 -> 548
    //   100: aload #5
    //   102: bipush #46
    //   104: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_0
    //   109: invokevirtual isFocusable : ()Z
    //   112: ifeq -> 559
    //   115: bipush #70
    //   117: istore_1
    //   118: aload #5
    //   120: iload_1
    //   121: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_0
    //   126: invokevirtual isEnabled : ()Z
    //   129: ifeq -> 565
    //   132: bipush #69
    //   134: istore_1
    //   135: aload #5
    //   137: iload_1
    //   138: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_0
    //   143: invokevirtual willNotDraw : ()Z
    //   146: ifeq -> 571
    //   149: bipush #46
    //   151: istore_1
    //   152: aload #5
    //   154: iload_1
    //   155: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_0
    //   160: invokevirtual isHorizontalScrollBarEnabled : ()Z
    //   163: ifeq -> 577
    //   166: bipush #72
    //   168: istore_1
    //   169: aload #5
    //   171: iload_1
    //   172: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_0
    //   177: invokevirtual isVerticalScrollBarEnabled : ()Z
    //   180: ifeq -> 583
    //   183: bipush #86
    //   185: istore_1
    //   186: aload #5
    //   188: iload_1
    //   189: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_0
    //   194: invokevirtual isClickable : ()Z
    //   197: ifeq -> 589
    //   200: bipush #67
    //   202: istore_1
    //   203: aload #5
    //   205: iload_1
    //   206: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: aload_0
    //   211: invokevirtual isLongClickable : ()Z
    //   214: ifeq -> 595
    //   217: bipush #76
    //   219: istore_1
    //   220: aload #5
    //   222: iload_1
    //   223: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload #5
    //   229: bipush #32
    //   231: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload_0
    //   236: invokevirtual isFocused : ()Z
    //   239: ifeq -> 601
    //   242: iload_3
    //   243: istore_1
    //   244: aload #5
    //   246: iload_1
    //   247: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: aload_0
    //   252: invokevirtual isSelected : ()Z
    //   255: ifeq -> 607
    //   258: bipush #83
    //   260: istore_1
    //   261: aload #5
    //   263: iload_1
    //   264: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: iload_2
    //   269: istore_1
    //   270: aload_0
    //   271: invokevirtual isPressed : ()Z
    //   274: ifeq -> 280
    //   277: bipush #80
    //   279: istore_1
    //   280: aload #5
    //   282: iload_1
    //   283: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload #5
    //   289: bipush #32
    //   291: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload #5
    //   297: aload_0
    //   298: invokevirtual getLeft : ()I
    //   301: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: aload #5
    //   307: bipush #44
    //   309: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload #5
    //   315: aload_0
    //   316: invokevirtual getTop : ()I
    //   319: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload #5
    //   325: bipush #45
    //   327: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload #5
    //   333: aload_0
    //   334: invokevirtual getRight : ()I
    //   337: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload #5
    //   343: bipush #44
    //   345: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   348: pop
    //   349: aload #5
    //   351: aload_0
    //   352: invokevirtual getBottom : ()I
    //   355: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_0
    //   360: invokevirtual getId : ()I
    //   363: istore #4
    //   365: iload #4
    //   367: iconst_m1
    //   368: if_icmpeq -> 511
    //   371: aload #5
    //   373: ldc ' #'
    //   375: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload #5
    //   381: iload #4
    //   383: invokestatic toHexString : (I)Ljava/lang/String;
    //   386: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_0
    //   391: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   394: astore #6
    //   396: iload #4
    //   398: ifeq -> 511
    //   401: aload #6
    //   403: ifnull -> 511
    //   406: ldc -16777216
    //   408: iload #4
    //   410: iand
    //   411: lookupswitch default -> 436, 16777216 -> 620, 2130706432 -> 613
    //   436: aload #6
    //   438: iload #4
    //   440: invokevirtual getResourcePackageName : (I)Ljava/lang/String;
    //   443: astore_0
    //   444: aload #6
    //   446: iload #4
    //   448: invokevirtual getResourceTypeName : (I)Ljava/lang/String;
    //   451: astore #7
    //   453: aload #6
    //   455: iload #4
    //   457: invokevirtual getResourceEntryName : (I)Ljava/lang/String;
    //   460: astore #6
    //   462: aload #5
    //   464: ldc ' '
    //   466: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload #5
    //   472: aload_0
    //   473: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload #5
    //   479: ldc_w ':'
    //   482: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload #5
    //   488: aload #7
    //   490: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload #5
    //   496: ldc_w '/'
    //   499: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: pop
    //   503: aload #5
    //   505: aload #6
    //   507: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: aload #5
    //   513: ldc_w '}'
    //   516: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload #5
    //   522: invokevirtual toString : ()Ljava/lang/String;
    //   525: areturn
    //   526: aload #5
    //   528: bipush #86
    //   530: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: goto -> 108
    //   537: aload #5
    //   539: bipush #73
    //   541: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: goto -> 108
    //   548: aload #5
    //   550: bipush #71
    //   552: invokevirtual append : (C)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: goto -> 108
    //   559: bipush #46
    //   561: istore_1
    //   562: goto -> 118
    //   565: bipush #46
    //   567: istore_1
    //   568: goto -> 135
    //   571: bipush #68
    //   573: istore_1
    //   574: goto -> 152
    //   577: bipush #46
    //   579: istore_1
    //   580: goto -> 169
    //   583: bipush #46
    //   585: istore_1
    //   586: goto -> 186
    //   589: bipush #46
    //   591: istore_1
    //   592: goto -> 203
    //   595: bipush #46
    //   597: istore_1
    //   598: goto -> 220
    //   601: bipush #46
    //   603: istore_1
    //   604: goto -> 244
    //   607: bipush #46
    //   609: istore_1
    //   610: goto -> 261
    //   613: ldc_w 'app'
    //   616: astore_0
    //   617: goto -> 444
    //   620: ldc_w 'android'
    //   623: astore_0
    //   624: goto -> 444
    //   627: astore_0
    //   628: goto -> 511
    // Exception table:
    //   from	to	target	type
    //   436	444	627	android/content/res/Resources$NotFoundException
    //   444	511	627	android/content/res/Resources$NotFoundException
  }
  
  final View dispatchFragmentsOnCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet) {
    return this.mFragments.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  void doReallyStop(boolean paramBoolean) {
    if (!this.mReallyStopped) {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
      return;
    } 
    if (paramBoolean) {
      this.mFragments.doLoaderStart();
      this.mFragments.doLoaderStop(true);
      return;
    } 
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString) {
    if (Build.VERSION.SDK_INT >= 11);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    this.mFragments.dumpLoaders(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    this.mFragments.getSupportFragmentManager().dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    dumpViewHierarchy(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }
  
  public Object getLastCustomNonConfigurationInstance() {
    NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    return (nonConfigurationInstances != null) ? nonConfigurationInstances.custom : null;
  }
  
  public FragmentManager getSupportFragmentManager() {
    return this.mFragments.getSupportFragmentManager();
  }
  
  public LoaderManager getSupportLoaderManager() {
    return this.mFragments.getSupportLoaderManager();
  }
  
  @Deprecated
  public final MediaControllerCompat getSupportMediaController() {
    return MediaControllerCompat.getMediaController(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0) {
      String str = (String)this.mPendingFragmentActivityResults.get(--i);
      this.mPendingFragmentActivityResults.remove(i);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
      Fragment fragment = this.mFragments.findFragmentByWho(str);
      if (fragment == null) {
        Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
        return;
      } 
      fragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    } 
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttachFragment(Fragment paramFragment) {}
  
  public void onBackPressed() {
    if (!this.mFragments.getSupportFragmentManager().popBackStackImmediate())
      super.onBackPressed(); 
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration) {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle) {
    FragmentManagerNonConfig fragmentManagerNonConfig = null;
    this.mFragments.attachHost(null);
    super.onCreate(paramBundle);
    NonConfigurationInstances nonConfigurationInstances = (NonConfigurationInstances)getLastNonConfigurationInstance();
    if (nonConfigurationInstances != null)
      this.mFragments.restoreLoaderNonConfig(nonConfigurationInstances.loaders); 
    if (paramBundle != null) {
      Parcelable parcelable = paramBundle.getParcelable("android:support:fragments");
      FragmentController fragmentController = this.mFragments;
      if (nonConfigurationInstances != null)
        fragmentManagerNonConfig = nonConfigurationInstances.fragments; 
      fragmentController.restoreAllState(parcelable, fragmentManagerNonConfig);
      if (paramBundle.containsKey("android:support:next_request_index")) {
        this.mNextCandidateRequestIndex = paramBundle.getInt("android:support:next_request_index");
        int[] arrayOfInt = paramBundle.getIntArray("android:support:request_indicies");
        String[] arrayOfString = paramBundle.getStringArray("android:support:request_fragment_who");
        if (arrayOfInt == null || arrayOfString == null || arrayOfInt.length != arrayOfString.length) {
          Log.w("FragmentActivity", "Invalid requestCode mapping in savedInstanceState.");
        } else {
          this.mPendingFragmentActivityResults = new SparseArrayCompat(arrayOfInt.length);
          int i = 0;
          while (true) {
            if (i < arrayOfInt.length) {
              this.mPendingFragmentActivityResults.put(arrayOfInt[i], arrayOfString[i]);
              i++;
              continue;
            } 
            if (this.mPendingFragmentActivityResults == null) {
              this.mPendingFragmentActivityResults = new SparseArrayCompat();
              this.mNextCandidateRequestIndex = 0;
            } 
            this.mFragments.dispatchCreate();
            return;
          } 
        } 
      } 
    } 
    if (this.mPendingFragmentActivityResults == null) {
      this.mPendingFragmentActivityResults = new SparseArrayCompat();
      this.mNextCandidateRequestIndex = 0;
    } 
    this.mFragments.dispatchCreate();
  }
  
  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu) {
    if (paramInt == 0) {
      boolean bool1 = super.onCreatePanelMenu(paramInt, paramMenu);
      boolean bool2 = this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
      return (Build.VERSION.SDK_INT >= 11) ? (bool1 | bool2) : true;
    } 
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }
  
  protected void onDestroy() {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.dispatchDestroy();
    this.mFragments.doLoaderDestroy();
  }
  
  public void onLowMemory() {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }
  
  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem) {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true; 
    switch (paramInt) {
      default:
        return false;
      case 0:
        return this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
      case 6:
        break;
    } 
    return this.mFragments.dispatchContextItemSelected(paramMenuItem);
  }
  
  @CallSuper
  public void onMultiWindowModeChanged(boolean paramBoolean) {
    this.mFragments.dispatchMultiWindowModeChanged(paramBoolean);
  }
  
  protected void onNewIntent(Intent paramIntent) {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu) {
    switch (paramInt) {
      default:
        super.onPanelClosed(paramInt, paramMenu);
        return;
      case 0:
        break;
    } 
    this.mFragments.dispatchOptionsMenuClosed(paramMenu);
  }
  
  protected void onPause() {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2)) {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    } 
    this.mFragments.dispatchPause();
  }
  
  @CallSuper
  public void onPictureInPictureModeChanged(boolean paramBoolean) {
    this.mFragments.dispatchPictureInPictureModeChanged(paramBoolean);
  }
  
  protected void onPostResume() {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu) {
    return super.onPreparePanel(0, paramView, paramMenu);
  }
  
  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu) {
    if (paramInt == 0 && paramMenu != null) {
      if (this.mOptionsMenuInvalidated) {
        this.mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      } 
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu);
    } 
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }
  
  void onReallyStop() {
    this.mFragments.doLoaderStop(this.mRetaining);
    this.mFragments.dispatchReallyStop();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfint) {
    String str;
    int i = paramInt >> 16 & 0xFFFF;
    if (i != 0) {
      str = (String)this.mPendingFragmentActivityResults.get(--i);
      this.mPendingFragmentActivityResults.remove(i);
      if (str == null) {
        Log.w("FragmentActivity", "Activity result delivered for unknown Fragment.");
        return;
      } 
    } else {
      return;
    } 
    Fragment fragment = this.mFragments.findFragmentByWho(str);
    if (fragment == null) {
      Log.w("FragmentActivity", "Activity result no fragment exists for who: " + str);
      return;
    } 
    fragment.onRequestPermissionsResult(paramInt & 0xFFFF, paramArrayOfString, paramArrayOfint);
  }
  
  protected void onResume() {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }
  
  protected void onResumeFragments() {
    this.mFragments.dispatchResume();
  }
  
  public Object onRetainCustomNonConfigurationInstance() {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance() {
    if (this.mStopped)
      doReallyStop(true); 
    Object object = onRetainCustomNonConfigurationInstance();
    FragmentManagerNonConfig fragmentManagerNonConfig = this.mFragments.retainNestedNonConfig();
    SimpleArrayMap<String, LoaderManager> simpleArrayMap = this.mFragments.retainLoaderNonConfig();
    if (fragmentManagerNonConfig == null && simpleArrayMap == null && object == null)
      return null; 
    NonConfigurationInstances nonConfigurationInstances = new NonConfigurationInstances();
    nonConfigurationInstances.custom = object;
    nonConfigurationInstances.fragments = fragmentManagerNonConfig;
    nonConfigurationInstances.loaders = simpleArrayMap;
    return nonConfigurationInstances;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {
    super.onSaveInstanceState(paramBundle);
    Parcelable parcelable = this.mFragments.saveAllState();
    if (parcelable != null)
      paramBundle.putParcelable("android:support:fragments", parcelable); 
    if (this.mPendingFragmentActivityResults.size() > 0) {
      paramBundle.putInt("android:support:next_request_index", this.mNextCandidateRequestIndex);
      int[] arrayOfInt = new int[this.mPendingFragmentActivityResults.size()];
      String[] arrayOfString = new String[this.mPendingFragmentActivityResults.size()];
      for (int i = 0; i < this.mPendingFragmentActivityResults.size(); i++) {
        arrayOfInt[i] = this.mPendingFragmentActivityResults.keyAt(i);
        arrayOfString[i] = (String)this.mPendingFragmentActivityResults.valueAt(i);
      } 
      paramBundle.putIntArray("android:support:request_indicies", arrayOfInt);
      paramBundle.putStringArray("android:support:request_fragment_who", arrayOfString);
    } 
  }
  
  protected void onStart() {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated) {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    } 
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    this.mFragments.doLoaderStart();
    this.mFragments.dispatchStart();
    this.mFragments.reportLoaderStart();
  }
  
  public void onStateNotSaved() {
    this.mFragments.noteStateNotSaved();
  }
  
  protected void onStop() {
    super.onStop();
    this.mStopped = true;
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.dispatchStop();
  }
  
  void requestPermissionsFromFragment(Fragment paramFragment, String[] paramArrayOfString, int paramInt) {
    if (paramInt == -1) {
      ActivityCompat.requestPermissions(this, paramArrayOfString, paramInt);
      return;
    } 
    checkForValidRequestCode(paramInt);
    try {
      this.mRequestedPermissionsFromFragment = true;
      ActivityCompat.requestPermissions(this, paramArrayOfString, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt));
      return;
    } finally {
      this.mRequestedPermissionsFromFragment = false;
    } 
  }
  
  public void setEnterSharedElementCallback(SharedElementCallback paramSharedElementCallback) {
    ActivityCompat.setEnterSharedElementCallback(this, paramSharedElementCallback);
  }
  
  public void setExitSharedElementCallback(SharedElementCallback paramSharedElementCallback) {
    ActivityCompat.setExitSharedElementCallback(this, paramSharedElementCallback);
  }
  
  @Deprecated
  public final void setSupportMediaController(MediaControllerCompat paramMediaControllerCompat) {
    MediaControllerCompat.setMediaController(this, paramMediaControllerCompat);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt) {
    if (!this.mStartedActivityFromFragment && paramInt != -1)
      checkForValidRequestCode(paramInt); 
    super.startActivityForResult(paramIntent, paramInt);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt) {
    startActivityFromFragment(paramFragment, paramIntent, paramInt, (Bundle)null);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, @Nullable Bundle paramBundle) {
    this.mStartedActivityFromFragment = true;
    if (paramInt == -1)
      try {
        ActivityCompat.startActivityForResult(this, paramIntent, -1, paramBundle);
        return;
      } finally {
        this.mStartedActivityFromFragment = false;
      }  
    checkForValidRequestCode(paramInt);
    ActivityCompat.startActivityForResult(this, paramIntent, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt), paramBundle);
    this.mStartedActivityFromFragment = false;
  }
  
  public void startIntentSenderFromFragment(Fragment paramFragment, IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle) throws IntentSender.SendIntentException {
    this.mStartedIntentSenderFromFragment = true;
    if (paramInt1 == -1)
      try {
        ActivityCompat.startIntentSenderForResult(this, paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
        return;
      } finally {
        this.mStartedIntentSenderFromFragment = false;
      }  
    checkForValidRequestCode(paramInt1);
    ActivityCompat.startIntentSenderForResult(this, paramIntentSender, (allocateRequestIndex(paramFragment) + 1 << 16) + (0xFFFF & paramInt1), paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    this.mStartedIntentSenderFromFragment = false;
  }
  
  public void supportFinishAfterTransition() {
    ActivityCompat.finishAfterTransition(this);
  }
  
  public void supportInvalidateOptionsMenu() {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(this);
      return;
    } 
    this.mOptionsMenuInvalidated = true;
  }
  
  public void supportPostponeEnterTransition() {
    ActivityCompat.postponeEnterTransition(this);
  }
  
  public void supportStartPostponedEnterTransition() {
    ActivityCompat.startPostponedEnterTransition(this);
  }
  
  public final void validateRequestPermissionsRequestCode(int paramInt) {
    if (!this.mRequestedPermissionsFromFragment && paramInt != -1)
      checkForValidRequestCode(paramInt); 
  }
  
  class HostCallbacks extends FragmentHostCallback<FragmentActivity> {
    public HostCallbacks() {
      super(FragmentActivity.this);
    }
    
    public void onAttachFragment(Fragment param1Fragment) {
      FragmentActivity.this.onAttachFragment(param1Fragment);
    }
    
    @SuppressLint({"NewApi"})
    public void onDump(String param1String, FileDescriptor param1FileDescriptor, PrintWriter param1PrintWriter, String[] param1ArrayOfString) {
      FragmentActivity.this.dump(param1String, param1FileDescriptor, param1PrintWriter, param1ArrayOfString);
    }
    
    @Nullable
    public View onFindViewById(int param1Int) {
      return FragmentActivity.this.findViewById(param1Int);
    }
    
    public FragmentActivity onGetHost() {
      return FragmentActivity.this;
    }
    
    public LayoutInflater onGetLayoutInflater() {
      return FragmentActivity.this.getLayoutInflater().cloneInContext((Context)FragmentActivity.this);
    }
    
    public int onGetWindowAnimations() {
      Window window = FragmentActivity.this.getWindow();
      return (window == null) ? 0 : (window.getAttributes()).windowAnimations;
    }
    
    public boolean onHasView() {
      Window window = FragmentActivity.this.getWindow();
      return (window != null && window.peekDecorView() != null);
    }
    
    public boolean onHasWindowAnimations() {
      return (FragmentActivity.this.getWindow() != null);
    }
    
    public void onRequestPermissionsFromFragment(@NonNull Fragment param1Fragment, @NonNull String[] param1ArrayOfString, int param1Int) {
      FragmentActivity.this.requestPermissionsFromFragment(param1Fragment, param1ArrayOfString, param1Int);
    }
    
    public boolean onShouldSaveFragmentState(Fragment param1Fragment) {
      return !FragmentActivity.this.isFinishing();
    }
    
    public boolean onShouldShowRequestPermissionRationale(@NonNull String param1String) {
      return ActivityCompat.shouldShowRequestPermissionRationale(FragmentActivity.this, param1String);
    }
    
    public void onStartActivityFromFragment(Fragment param1Fragment, Intent param1Intent, int param1Int) {
      FragmentActivity.this.startActivityFromFragment(param1Fragment, param1Intent, param1Int);
    }
    
    public void onStartActivityFromFragment(Fragment param1Fragment, Intent param1Intent, int param1Int, @Nullable Bundle param1Bundle) {
      FragmentActivity.this.startActivityFromFragment(param1Fragment, param1Intent, param1Int, param1Bundle);
    }
    
    public void onStartIntentSenderFromFragment(Fragment param1Fragment, IntentSender param1IntentSender, int param1Int1, @Nullable Intent param1Intent, int param1Int2, int param1Int3, int param1Int4, Bundle param1Bundle) throws IntentSender.SendIntentException {
      FragmentActivity.this.startIntentSenderFromFragment(param1Fragment, param1IntentSender, param1Int1, param1Intent, param1Int2, param1Int3, param1Int4, param1Bundle);
    }
    
    public void onSupportInvalidateOptionsMenu() {
      FragmentActivity.this.supportInvalidateOptionsMenu();
    }
  }
  
  static final class NonConfigurationInstances {
    Object custom;
    
    FragmentManagerNonConfig fragments;
    
    SimpleArrayMap<String, LoaderManager> loaders;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\FragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */