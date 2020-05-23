package android.support.v4.hardware.fingerprint;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public final class FingerprintManagerCompat {
  static final FingerprintManagerCompatImpl IMPL = new LegacyFingerprintManagerCompatImpl();
  
  private Context mContext;
  
  private FingerprintManagerCompat(Context paramContext) {
    this.mContext = paramContext;
  }
  
  public static FingerprintManagerCompat from(Context paramContext) {
    return new FingerprintManagerCompat(paramContext);
  }
  
  public void authenticate(@Nullable CryptoObject paramCryptoObject, int paramInt, @Nullable CancellationSignal paramCancellationSignal, @NonNull AuthenticationCallback paramAuthenticationCallback, @Nullable Handler paramHandler) {
    IMPL.authenticate(this.mContext, paramCryptoObject, paramInt, paramCancellationSignal, paramAuthenticationCallback, paramHandler);
  }
  
  public boolean hasEnrolledFingerprints() {
    return IMPL.hasEnrolledFingerprints(this.mContext);
  }
  
  public boolean isHardwareDetected() {
    return IMPL.isHardwareDetected(this.mContext);
  }
  
  static {
    if (Build.VERSION.SDK_INT >= 23) {
      IMPL = new Api23FingerprintManagerCompatImpl();
      return;
    } 
  }
  
  private static class Api23FingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
    static FingerprintManagerCompat.CryptoObject unwrapCryptoObject(FingerprintManagerCompatApi23.CryptoObject param1CryptoObject) {
      if (param1CryptoObject != null) {
        if (param1CryptoObject.getCipher() != null)
          return new FingerprintManagerCompat.CryptoObject(param1CryptoObject.getCipher()); 
        if (param1CryptoObject.getSignature() != null)
          return new FingerprintManagerCompat.CryptoObject(param1CryptoObject.getSignature()); 
        if (param1CryptoObject.getMac() != null)
          return new FingerprintManagerCompat.CryptoObject(param1CryptoObject.getMac()); 
      } 
      return null;
    }
    
    private static FingerprintManagerCompatApi23.AuthenticationCallback wrapCallback(final FingerprintManagerCompat.AuthenticationCallback callback) {
      return new FingerprintManagerCompatApi23.AuthenticationCallback() {
          public void onAuthenticationError(int param2Int, CharSequence param2CharSequence) {
            callback.onAuthenticationError(param2Int, param2CharSequence);
          }
          
          public void onAuthenticationFailed() {
            callback.onAuthenticationFailed();
          }
          
          public void onAuthenticationHelp(int param2Int, CharSequence param2CharSequence) {
            callback.onAuthenticationHelp(param2Int, param2CharSequence);
          }
          
          public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal param2AuthenticationResultInternal) {
            callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.unwrapCryptoObject(param2AuthenticationResultInternal.getCryptoObject())));
          }
        };
    }
    
    private static FingerprintManagerCompatApi23.CryptoObject wrapCryptoObject(FingerprintManagerCompat.CryptoObject param1CryptoObject) {
      if (param1CryptoObject != null) {
        if (param1CryptoObject.getCipher() != null)
          return new FingerprintManagerCompatApi23.CryptoObject(param1CryptoObject.getCipher()); 
        if (param1CryptoObject.getSignature() != null)
          return new FingerprintManagerCompatApi23.CryptoObject(param1CryptoObject.getSignature()); 
        if (param1CryptoObject.getMac() != null)
          return new FingerprintManagerCompatApi23.CryptoObject(param1CryptoObject.getMac()); 
      } 
      return null;
    }
    
    public void authenticate(Context param1Context, FingerprintManagerCompat.CryptoObject param1CryptoObject, int param1Int, CancellationSignal param1CancellationSignal, FingerprintManagerCompat.AuthenticationCallback param1AuthenticationCallback, Handler param1Handler) {
      FingerprintManagerCompatApi23.CryptoObject cryptoObject = wrapCryptoObject(param1CryptoObject);
      if (param1CancellationSignal != null) {
        Object object = param1CancellationSignal.getCancellationSignalObject();
      } else {
        param1CryptoObject = null;
      } 
      FingerprintManagerCompatApi23.authenticate(param1Context, cryptoObject, param1Int, param1CryptoObject, wrapCallback(param1AuthenticationCallback), param1Handler);
    }
    
    public boolean hasEnrolledFingerprints(Context param1Context) {
      return FingerprintManagerCompatApi23.hasEnrolledFingerprints(param1Context);
    }
    
    public boolean isHardwareDetected(Context param1Context) {
      return FingerprintManagerCompatApi23.isHardwareDetected(param1Context);
    }
  }
  
  static final class null extends FingerprintManagerCompatApi23.AuthenticationCallback {
    public void onAuthenticationError(int param1Int, CharSequence param1CharSequence) {
      callback.onAuthenticationError(param1Int, param1CharSequence);
    }
    
    public void onAuthenticationFailed() {
      callback.onAuthenticationFailed();
    }
    
    public void onAuthenticationHelp(int param1Int, CharSequence param1CharSequence) {
      callback.onAuthenticationHelp(param1Int, param1CharSequence);
    }
    
    public void onAuthenticationSucceeded(FingerprintManagerCompatApi23.AuthenticationResultInternal param1AuthenticationResultInternal) {
      callback.onAuthenticationSucceeded(new FingerprintManagerCompat.AuthenticationResult(FingerprintManagerCompat.Api23FingerprintManagerCompatImpl.unwrapCryptoObject(param1AuthenticationResultInternal.getCryptoObject())));
    }
  }
  
  public static abstract class AuthenticationCallback {
    public void onAuthenticationError(int param1Int, CharSequence param1CharSequence) {}
    
    public void onAuthenticationFailed() {}
    
    public void onAuthenticationHelp(int param1Int, CharSequence param1CharSequence) {}
    
    public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult param1AuthenticationResult) {}
  }
  
  public static final class AuthenticationResult {
    private FingerprintManagerCompat.CryptoObject mCryptoObject;
    
    public AuthenticationResult(FingerprintManagerCompat.CryptoObject param1CryptoObject) {
      this.mCryptoObject = param1CryptoObject;
    }
    
    public FingerprintManagerCompat.CryptoObject getCryptoObject() {
      return this.mCryptoObject;
    }
  }
  
  public static class CryptoObject {
    private final Cipher mCipher;
    
    private final Mac mMac;
    
    private final Signature mSignature;
    
    public CryptoObject(Signature param1Signature) {
      this.mSignature = param1Signature;
      this.mCipher = null;
      this.mMac = null;
    }
    
    public CryptoObject(Cipher param1Cipher) {
      this.mCipher = param1Cipher;
      this.mSignature = null;
      this.mMac = null;
    }
    
    public CryptoObject(Mac param1Mac) {
      this.mMac = param1Mac;
      this.mCipher = null;
      this.mSignature = null;
    }
    
    public Cipher getCipher() {
      return this.mCipher;
    }
    
    public Mac getMac() {
      return this.mMac;
    }
    
    public Signature getSignature() {
      return this.mSignature;
    }
  }
  
  private static interface FingerprintManagerCompatImpl {
    void authenticate(Context param1Context, FingerprintManagerCompat.CryptoObject param1CryptoObject, int param1Int, CancellationSignal param1CancellationSignal, FingerprintManagerCompat.AuthenticationCallback param1AuthenticationCallback, Handler param1Handler);
    
    boolean hasEnrolledFingerprints(Context param1Context);
    
    boolean isHardwareDetected(Context param1Context);
  }
  
  private static class LegacyFingerprintManagerCompatImpl implements FingerprintManagerCompatImpl {
    public void authenticate(Context param1Context, FingerprintManagerCompat.CryptoObject param1CryptoObject, int param1Int, CancellationSignal param1CancellationSignal, FingerprintManagerCompat.AuthenticationCallback param1AuthenticationCallback, Handler param1Handler) {}
    
    public boolean hasEnrolledFingerprints(Context param1Context) {
      return false;
    }
    
    public boolean isHardwareDetected(Context param1Context) {
      return false;
    }
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\hardware\fingerprint\FingerprintManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */