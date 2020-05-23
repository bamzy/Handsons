package com.drms.drms_drone.Upload;

import android.app.Activity;
import com.drms.drms_drone.Communication.ClassicBluetooth.BluetoothService;

public class DroneUploadManager {
  private Activity mActivity;
  
  private BluetoothService mBluetoothService;
  
  public DroneUploadManager(Activity paramActivity, BluetoothService paramBluetoothService) {
    this.mBluetoothService = paramBluetoothService;
    this.mActivity = paramActivity;
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Upload\DroneUploadManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */