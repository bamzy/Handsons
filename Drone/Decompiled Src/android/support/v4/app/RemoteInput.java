package android.support.v4.app;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import android.util.Log;

public final class RemoteInput extends RemoteInputCompatBase.RemoteInput {
  public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
  
  @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
  public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() {
      public RemoteInput build(String param1String, CharSequence param1CharSequence, CharSequence[] param1ArrayOfCharSequence, boolean param1Boolean, Bundle param1Bundle) {
        return new RemoteInput(param1String, param1CharSequence, param1ArrayOfCharSequence, param1Boolean, param1Bundle);
      }
      
      public RemoteInput[] newArray(int param1Int) {
        return new RemoteInput[param1Int];
      }
    };
  
  private static final Impl IMPL;
  
  public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
  
  private static final String TAG = "RemoteInput";
  
  private final boolean mAllowFreeFormInput;
  
  private final CharSequence[] mChoices;
  
  private final Bundle mExtras;
  
  private final CharSequence mLabel;
  
  private final String mResultKey;
  
  RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle) {
    this.mResultKey = paramString;
    this.mLabel = paramCharSequence;
    this.mChoices = paramArrayOfCharSequence;
    this.mAllowFreeFormInput = paramBoolean;
    this.mExtras = paramBundle;
  }
  
  public static void addResultsToIntent(RemoteInput[] paramArrayOfRemoteInput, Intent paramIntent, Bundle paramBundle) {
    IMPL.addResultsToIntent(paramArrayOfRemoteInput, paramIntent, paramBundle);
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent) {
    return IMPL.getResultsFromIntent(paramIntent);
  }
  
  public boolean getAllowFreeFormInput() {
    return this.mAllowFreeFormInput;
  }
  
  public CharSequence[] getChoices() {
    return this.mChoices;
  }
  
  public Bundle getExtras() {
    return this.mExtras;
  }
  
  public CharSequence getLabel() {
    return this.mLabel;
  }
  
  public String getResultKey() {
    return this.mResultKey;
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 20) {
      IMPL = new ImplApi20();
    } else if (Build.VERSION.SDK_INT >= 16) {
      IMPL = new ImplJellybean();
    } else {
      IMPL = new ImplBase();
    } 
  }
  
  public static final class Builder {
    private boolean mAllowFreeFormInput = true;
    
    private CharSequence[] mChoices;
    
    private Bundle mExtras = new Bundle();
    
    private CharSequence mLabel;
    
    private final String mResultKey;
    
    public Builder(String param1String) {
      if (param1String == null)
        throw new IllegalArgumentException("Result key can't be null"); 
      this.mResultKey = param1String;
    }
    
    public Builder addExtras(Bundle param1Bundle) {
      if (param1Bundle != null)
        this.mExtras.putAll(param1Bundle); 
      return this;
    }
    
    public RemoteInput build() {
      return new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormInput, this.mExtras);
    }
    
    public Bundle getExtras() {
      return this.mExtras;
    }
    
    public Builder setAllowFreeFormInput(boolean param1Boolean) {
      this.mAllowFreeFormInput = param1Boolean;
      return this;
    }
    
    public Builder setChoices(CharSequence[] param1ArrayOfCharSequence) {
      this.mChoices = param1ArrayOfCharSequence;
      return this;
    }
    
    public Builder setLabel(CharSequence param1CharSequence) {
      this.mLabel = param1CharSequence;
      return this;
    }
  }
  
  static interface Impl {
    void addResultsToIntent(RemoteInput[] param1ArrayOfRemoteInput, Intent param1Intent, Bundle param1Bundle);
    
    Bundle getResultsFromIntent(Intent param1Intent);
  }
  
  static class ImplApi20 implements Impl {
    public void addResultsToIntent(RemoteInput[] param1ArrayOfRemoteInput, Intent param1Intent, Bundle param1Bundle) {
      RemoteInputCompatApi20.addResultsToIntent((RemoteInputCompatBase.RemoteInput[])param1ArrayOfRemoteInput, param1Intent, param1Bundle);
    }
    
    public Bundle getResultsFromIntent(Intent param1Intent) {
      return RemoteInputCompatApi20.getResultsFromIntent(param1Intent);
    }
  }
  
  static class ImplBase implements Impl {
    public void addResultsToIntent(RemoteInput[] param1ArrayOfRemoteInput, Intent param1Intent, Bundle param1Bundle) {
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
    }
    
    public Bundle getResultsFromIntent(Intent param1Intent) {
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
      return null;
    }
  }
  
  static class ImplJellybean implements Impl {
    public void addResultsToIntent(RemoteInput[] param1ArrayOfRemoteInput, Intent param1Intent, Bundle param1Bundle) {
      RemoteInputCompatJellybean.addResultsToIntent((RemoteInputCompatBase.RemoteInput[])param1ArrayOfRemoteInput, param1Intent, param1Bundle);
    }
    
    public Bundle getResultsFromIntent(Intent param1Intent) {
      return RemoteInputCompatJellybean.getResultsFromIntent(param1Intent);
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\app\RemoteInput.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */