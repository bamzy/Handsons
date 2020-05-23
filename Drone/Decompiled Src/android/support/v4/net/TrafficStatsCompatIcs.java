package android.support.v4.net;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

@TargetApi(14)
@RequiresApi(14)
class TrafficStatsCompatIcs {
  public static void clearThreadStatsTag() {
    TrafficStats.clearThreadStatsTag();
  }
  
  public static int getThreadStatsTag() {
    return TrafficStats.getThreadStatsTag();
  }
  
  public static void incrementOperationCount(int paramInt) {
    TrafficStats.incrementOperationCount(paramInt);
  }
  
  public static void incrementOperationCount(int paramInt1, int paramInt2) {
    TrafficStats.incrementOperationCount(paramInt1, paramInt2);
  }
  
  public static void setThreadStatsTag(int paramInt) {
    TrafficStats.setThreadStatsTag(paramInt);
  }
  
  public static void tagDatagramSocket(DatagramSocket paramDatagramSocket) throws SocketException {
    ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket(paramDatagramSocket);
    TrafficStats.tagSocket(new DatagramSocketWrapper(paramDatagramSocket, parcelFileDescriptor.getFileDescriptor()));
    parcelFileDescriptor.detachFd();
  }
  
  public static void tagSocket(Socket paramSocket) throws SocketException {
    TrafficStats.tagSocket(paramSocket);
  }
  
  public static void untagDatagramSocket(DatagramSocket paramDatagramSocket) throws SocketException {
    ParcelFileDescriptor parcelFileDescriptor = ParcelFileDescriptor.fromDatagramSocket(paramDatagramSocket);
    TrafficStats.untagSocket(new DatagramSocketWrapper(paramDatagramSocket, parcelFileDescriptor.getFileDescriptor()));
    parcelFileDescriptor.detachFd();
  }
  
  public static void untagSocket(Socket paramSocket) throws SocketException {
    TrafficStats.untagSocket(paramSocket);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\android\support\v4\net\TrafficStatsCompatIcs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */