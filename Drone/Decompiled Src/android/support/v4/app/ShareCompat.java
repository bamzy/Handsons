package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public final class ShareCompat {
  public static final String EXTRA_CALLING_ACTIVITY = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  
  public static final String EXTRA_CALLING_PACKAGE = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  
  static ShareCompatImpl IMPL = new ShareCompatImplBase();
  
  public static void configureMenuItem(Menu paramMenu, int paramInt, IntentBuilder paramIntentBuilder) {
    MenuItem menuItem = paramMenu.findItem(paramInt);
    if (menuItem == null)
      throw new IllegalArgumentException("Could not find menu item with id " + paramInt + " in the supplied menu"); 
    configureMenuItem(menuItem, paramIntentBuilder);
  }
  
  public static void configureMenuItem(MenuItem paramMenuItem, IntentBuilder paramIntentBuilder) {
    IMPL.configureMenuItem(paramMenuItem, paramIntentBuilder);
  }
  
  public static ComponentName getCallingActivity(Activity paramActivity) {
    ComponentName componentName2 = paramActivity.getCallingActivity();
    ComponentName componentName1 = componentName2;
    if (componentName2 == null)
      componentName1 = (ComponentName)paramActivity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY"); 
    return componentName1;
  }
  
  public static String getCallingPackage(Activity paramActivity) {
    String str2 = paramActivity.getCallingPackage();
    String str1 = str2;
    if (str2 == null)
      str1 = paramActivity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE"); 
    return str1;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new ShareCompatImplJB();
      return;
    } 
    if (Build.VERSION.SDK_INT >= 14) {
      IMPL = new ShareCompatImplICS();
      return;
    } 
  }
  
  public static class IntentBuilder {
    private Activity mActivity;
    
    private ArrayList<String> mBccAddresses;
    
    private ArrayList<String> mCcAddresses;
    
    private CharSequence mChooserTitle;
    
    private Intent mIntent;
    
    private ArrayList<Uri> mStreams;
    
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(Activity param1Activity) {
      this.mActivity = param1Activity;
      this.mIntent = (new Intent()).setAction("android.intent.action.SEND");
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", param1Activity.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", (Parcelable)param1Activity.getComponentName());
      this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(String param1String, ArrayList<String> param1ArrayList) {
      byte b;
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(param1String);
      if (arrayOfString1 != null) {
        b = arrayOfString1.length;
      } else {
        b = 0;
      } 
      String[] arrayOfString2 = new String[param1ArrayList.size() + b];
      param1ArrayList.toArray(arrayOfString2);
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, param1ArrayList.size(), b); 
      this.mIntent.putExtra(param1String, arrayOfString2);
    }
    
    private void combineArrayExtra(String param1String, String[] param1ArrayOfString) {
      byte b;
      Intent intent = getIntent();
      String[] arrayOfString1 = intent.getStringArrayExtra(param1String);
      if (arrayOfString1 != null) {
        b = arrayOfString1.length;
      } else {
        b = 0;
      } 
      String[] arrayOfString2 = new String[param1ArrayOfString.length + b];
      if (arrayOfString1 != null)
        System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, b); 
      System.arraycopy(param1ArrayOfString, 0, arrayOfString2, b, param1ArrayOfString.length);
      intent.putExtra(param1String, arrayOfString2);
    }
    
    public static IntentBuilder from(Activity param1Activity) {
      return new IntentBuilder(param1Activity);
    }
    
    public IntentBuilder addEmailBcc(String param1String) {
      if (this.mBccAddresses == null)
        this.mBccAddresses = new ArrayList<String>(); 
      this.mBccAddresses.add(param1String);
      return this;
    }
    
    public IntentBuilder addEmailBcc(String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.BCC", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailCc(String param1String) {
      if (this.mCcAddresses == null)
        this.mCcAddresses = new ArrayList<String>(); 
      this.mCcAddresses.add(param1String);
      return this;
    }
    
    public IntentBuilder addEmailCc(String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.CC", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailTo(String param1String) {
      if (this.mToAddresses == null)
        this.mToAddresses = new ArrayList<String>(); 
      this.mToAddresses.add(param1String);
      return this;
    }
    
    public IntentBuilder addEmailTo(String[] param1ArrayOfString) {
      combineArrayExtra("android.intent.extra.EMAIL", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder addStream(Uri param1Uri) {
      Uri uri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if (this.mStreams == null && uri == null)
        return setStream(param1Uri); 
      if (this.mStreams == null)
        this.mStreams = new ArrayList<Uri>(); 
      if (uri != null) {
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        this.mStreams.add(uri);
      } 
      this.mStreams.add(param1Uri);
      return this;
    }
    
    public Intent createChooserIntent() {
      return Intent.createChooser(getIntent(), this.mChooserTitle);
    }
    
    Activity getActivity() {
      return this.mActivity;
    }
    
    public Intent getIntent() {
      boolean bool = true;
      if (this.mToAddresses != null) {
        combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
        this.mToAddresses = null;
      } 
      if (this.mCcAddresses != null) {
        combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
        this.mCcAddresses = null;
      } 
      if (this.mBccAddresses != null) {
        combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
        this.mBccAddresses = null;
      } 
      if (this.mStreams == null || this.mStreams.size() <= 1)
        bool = false; 
      boolean bool1 = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
      if (!bool && bool1) {
        this.mIntent.setAction("android.intent.action.SEND");
        if (this.mStreams != null && !this.mStreams.isEmpty()) {
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
        } else {
          this.mIntent.removeExtra("android.intent.extra.STREAM");
        } 
        this.mStreams = null;
      } 
      if (bool && !bool1) {
        this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
        if (this.mStreams != null && !this.mStreams.isEmpty()) {
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
          return this.mIntent;
        } 
      } else {
        return this.mIntent;
      } 
      this.mIntent.removeExtra("android.intent.extra.STREAM");
      return this.mIntent;
    }
    
    public IntentBuilder setChooserTitle(@StringRes int param1Int) {
      return setChooserTitle(this.mActivity.getText(param1Int));
    }
    
    public IntentBuilder setChooserTitle(CharSequence param1CharSequence) {
      this.mChooserTitle = param1CharSequence;
      return this;
    }
    
    public IntentBuilder setEmailBcc(String[] param1ArrayOfString) {
      this.mIntent.putExtra("android.intent.extra.BCC", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailCc(String[] param1ArrayOfString) {
      this.mIntent.putExtra("android.intent.extra.CC", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailTo(String[] param1ArrayOfString) {
      if (this.mToAddresses != null)
        this.mToAddresses = null; 
      this.mIntent.putExtra("android.intent.extra.EMAIL", param1ArrayOfString);
      return this;
    }
    
    public IntentBuilder setHtmlText(String param1String) {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", param1String);
      if (!this.mIntent.hasExtra("android.intent.extra.TEXT"))
        setText((CharSequence)Html.fromHtml(param1String)); 
      return this;
    }
    
    public IntentBuilder setStream(Uri param1Uri) {
      if (!this.mIntent.getAction().equals("android.intent.action.SEND"))
        this.mIntent.setAction("android.intent.action.SEND"); 
      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)param1Uri);
      return this;
    }
    
    public IntentBuilder setSubject(String param1String) {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", param1String);
      return this;
    }
    
    public IntentBuilder setText(CharSequence param1CharSequence) {
      this.mIntent.putExtra("android.intent.extra.TEXT", param1CharSequence);
      return this;
    }
    
    public IntentBuilder setType(String param1String) {
      this.mIntent.setType(param1String);
      return this;
    }
    
    public void startChooser() {
      this.mActivity.startActivity(createChooserIntent());
    }
  }
  
  public static class IntentReader {
    private static final String TAG = "IntentReader";
    
    private Activity mActivity;
    
    private ComponentName mCallingActivity;
    
    private String mCallingPackage;
    
    private Intent mIntent;
    
    private ArrayList<Uri> mStreams;
    
    private IntentReader(Activity param1Activity) {
      this.mActivity = param1Activity;
      this.mIntent = param1Activity.getIntent();
      this.mCallingPackage = ShareCompat.getCallingPackage(param1Activity);
      this.mCallingActivity = ShareCompat.getCallingActivity(param1Activity);
    }
    
    public static IntentReader from(Activity param1Activity) {
      return new IntentReader(param1Activity);
    }
    
    public ComponentName getCallingActivity() {
      return this.mCallingActivity;
    }
    
    public Drawable getCallingActivityIcon() {
      if (this.mCallingActivity == null)
        return null; 
      PackageManager packageManager = this.mActivity.getPackageManager();
      try {
        return packageManager.getActivityIcon(this.mCallingActivity);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("IntentReader", "Could not retrieve icon for calling activity", (Throwable)nameNotFoundException);
        return null;
      } 
    }
    
    public Drawable getCallingApplicationIcon() {
      if (this.mCallingPackage == null)
        return null; 
      PackageManager packageManager = this.mActivity.getPackageManager();
      try {
        return packageManager.getApplicationIcon(this.mCallingPackage);
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("IntentReader", "Could not retrieve icon for calling application", (Throwable)nameNotFoundException);
        return null;
      } 
    }
    
    public CharSequence getCallingApplicationLabel() {
      if (this.mCallingPackage == null)
        return null; 
      PackageManager packageManager = this.mActivity.getPackageManager();
      try {
        return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
      } catch (android.content.pm.PackageManager.NameNotFoundException nameNotFoundException) {
        Log.e("IntentReader", "Could not retrieve label for calling application", (Throwable)nameNotFoundException);
        return null;
      } 
    }
    
    public String getCallingPackage() {
      return this.mCallingPackage;
    }
    
    public String[] getEmailBcc() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }
    
    public String[] getEmailCc() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }
    
    public String[] getEmailTo() {
      return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }
    
    public String getHtmlText() {
      CharSequence charSequence;
      String str2 = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
      String str1 = str2;
      if (str2 == null) {
        charSequence = getText();
        if (charSequence instanceof Spanned)
          return Html.toHtml((Spanned)charSequence); 
      } else {
        return str1;
      } 
      str1 = str2;
      return (charSequence != null) ? ShareCompat.IMPL.escapeHtml(charSequence) : str1;
    }
    
    public Uri getStream() {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    
    public Uri getStream(int param1Int) {
      if (this.mStreams == null && isMultipleShare())
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"); 
      if (this.mStreams != null)
        return this.mStreams.get(param1Int); 
      if (param1Int == 0)
        return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM"); 
      throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + param1Int);
    }
    
    public int getStreamCount() {
      if (this.mStreams == null && isMultipleShare())
        this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM"); 
      return (this.mStreams != null) ? this.mStreams.size() : (this.mIntent.hasExtra("android.intent.extra.STREAM") ? 1 : 0);
    }
    
    public String getSubject() {
      return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }
    
    public CharSequence getText() {
      return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }
    
    public String getType() {
      return this.mIntent.getType();
    }
    
    public boolean isMultipleShare() {
      return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
    }
    
    public boolean isShareIntent() {
      String str = this.mIntent.getAction();
      return ("android.intent.action.SEND".equals(str) || "android.intent.action.SEND_MULTIPLE".equals(str));
    }
    
    public boolean isSingleShare() {
      return "android.intent.action.SEND".equals(this.mIntent.getAction());
    }
  }
  
  static interface ShareCompatImpl {
    void configureMenuItem(MenuItem param1MenuItem, ShareCompat.IntentBuilder param1IntentBuilder);
    
    String escapeHtml(CharSequence param1CharSequence);
  }
  
  static class ShareCompatImplBase implements ShareCompatImpl {
    private static void withinStyle(StringBuilder param1StringBuilder, CharSequence param1CharSequence, int param1Int1, int param1Int2) {
      while (param1Int1 < param1Int2) {
        char c = param1CharSequence.charAt(param1Int1);
        if (c == '<') {
          param1StringBuilder.append("&lt;");
        } else if (c == '>') {
          param1StringBuilder.append("&gt;");
        } else if (c == '&') {
          param1StringBuilder.append("&amp;");
        } else if (c > '~' || c < ' ') {
          param1StringBuilder.append("&#" + c + ";");
        } else if (c == ' ') {
          while (param1Int1 + 1 < param1Int2 && param1CharSequence.charAt(param1Int1 + 1) == ' ') {
            param1StringBuilder.append("&nbsp;");
            param1Int1++;
          } 
          param1StringBuilder.append(' ');
        } else {
          param1StringBuilder.append(c);
        } 
        param1Int1++;
      } 
    }
    
    public void configureMenuItem(MenuItem param1MenuItem, ShareCompat.IntentBuilder param1IntentBuilder) {
      param1MenuItem.setIntent(param1IntentBuilder.createChooserIntent());
    }
    
    public String escapeHtml(CharSequence param1CharSequence) {
      StringBuilder stringBuilder = new StringBuilder();
      withinStyle(stringBuilder, param1CharSequence, 0, param1CharSequence.length());
      return stringBuilder.toString();
    }
  }
  
  static class ShareCompatImplICS extends ShareCompatImplBase {
    public void configureMenuItem(MenuItem param1MenuItem, ShareCompat.IntentBuilder param1IntentBuilder) {
      ShareCompatICS.configureMenuItem(param1MenuItem, param1IntentBuilder.getActivity(), param1IntentBuilder.getIntent());
      if (shouldAddChooserIntent(param1MenuItem))
        param1MenuItem.setIntent(param1IntentBuilder.createChooserIntent()); 
    }
    
    boolean shouldAddChooserIntent(MenuItem param1MenuItem) {
      return !param1MenuItem.hasSubMenu();
    }
  }
  
  static class ShareCompatImplJB extends ShareCompatImplICS {
    public String escapeHtml(CharSequence param1CharSequence) {
      return ShareCompatJB.escapeHtml(param1CharSequence);
    }
    
    boolean shouldAddChooserIntent(MenuItem param1MenuItem) {
      return false;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\ShareCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */