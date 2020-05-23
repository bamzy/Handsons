package android.support.v4.media;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(21)
@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {
  public static Object createService(Context paramContext, ServiceCompatProxy paramServiceCompatProxy) {
    return new MediaBrowserServiceAdaptor(paramContext, paramServiceCompatProxy);
  }
  
  public static void notifyChildrenChanged(Object paramObject, String paramString) {
    ((MediaBrowserService)paramObject).notifyChildrenChanged(paramString);
  }
  
  public static IBinder onBind(Object paramObject, Intent paramIntent) {
    return ((MediaBrowserService)paramObject).onBind(paramIntent);
  }
  
  public static void onCreate(Object paramObject) {
    ((MediaBrowserService)paramObject).onCreate();
  }
  
  public static void setSessionToken(Object paramObject1, Object paramObject2) {
    ((MediaBrowserService)paramObject1).setSessionToken((MediaSession.Token)paramObject2);
  }
  
  static class BrowserRoot {
    final Bundle mExtras;
    
    final String mRootId;
    
    BrowserRoot(String param1String, Bundle param1Bundle) {
      this.mRootId = param1String;
      this.mExtras = param1Bundle;
    }
  }
  
  static class MediaBrowserServiceAdaptor extends MediaBrowserService {
    final MediaBrowserServiceCompatApi21.ServiceCompatProxy mServiceProxy;
    
    MediaBrowserServiceAdaptor(Context param1Context, MediaBrowserServiceCompatApi21.ServiceCompatProxy param1ServiceCompatProxy) {
      attachBaseContext(param1Context);
      this.mServiceProxy = param1ServiceCompatProxy;
    }
    
    public MediaBrowserService.BrowserRoot onGetRoot(String param1String, int param1Int, Bundle param1Bundle) {
      MediaBrowserServiceCompatApi21.BrowserRoot browserRoot = this.mServiceProxy.onGetRoot(param1String, param1Int, param1Bundle);
      return (browserRoot == null) ? null : new MediaBrowserService.BrowserRoot(browserRoot.mRootId, browserRoot.mExtras);
    }
    
    public void onLoadChildren(String param1String, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> param1Result) {
      this.mServiceProxy.onLoadChildren(param1String, new MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>>(param1Result));
    }
  }
  
  static class ResultWrapper<T> {
    MediaBrowserService.Result mResultObj;
    
    ResultWrapper(MediaBrowserService.Result param1Result) {
      this.mResultObj = param1Result;
    }
    
    public void detach() {
      this.mResultObj.detach();
    }
    
    List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> param1List) {
      if (param1List == null)
        return null; 
      ArrayList<Parcel> arrayList = new ArrayList();
      Iterator<Parcel> iterator = param1List.iterator();
      while (true) {
        Parcel parcel;
        param1List = arrayList;
        if (iterator.hasNext()) {
          parcel = iterator.next();
          parcel.setDataPosition(0);
          arrayList.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
          parcel.recycle();
          continue;
        } 
        return (List<MediaBrowser.MediaItem>)parcel;
      } 
    }
    
    public void sendResult(T param1T) {
      if (param1T instanceof List) {
        this.mResultObj.sendResult(parcelListToItemList((List<Parcel>)param1T));
        return;
      } 
      if (param1T instanceof Parcel) {
        Parcel parcel = (Parcel)param1T;
        parcel.setDataPosition(0);
        this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
        parcel.recycle();
        return;
      } 
      this.mResultObj.sendResult(null);
    }
  }
  
  public static interface ServiceCompatProxy {
    MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String param1String, int param1Int, Bundle param1Bundle);
    
    void onLoadChildren(String param1String, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> param1ResultWrapper);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\media\MediaBrowserServiceCompatApi21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */