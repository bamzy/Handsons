package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import java.net.DatagramSocket;
import java.net.SocketException;

@TargetApi(24)
@RequiresApi(24)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class TrafficStatsCompatApi24 {
  public static void tagDatagramSocket(DatagramSocket paramDatagramSocket) throws SocketException {
    TrafficStats.tagDatagramSocket(paramDatagramSocket);
  }
  
  public static void untagDatagramSocket(DatagramSocket paramDatagramSocket) throws SocketException {
    TrafficStats.untagDatagramSocket(paramDatagramSocket);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\net\TrafficStatsCompatApi24.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */