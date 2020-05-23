package com.drms.drms_drone.Communication.ClassicBluetooth;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.drms.drms_drone.CustomAdapter.CustomAdatper2.Custom2_Item;
import com.drms.drms_drone.CustomAdapter.CustomAdatper2.CustomAdapter2;
import java.util.Set;

public class DeviceListActivity extends Activity {
  private static final boolean D = true;
  
  public static String EXTRA_DEVICE_ADDRESS = "device_address";
  
  public static String EXTRA_DEVICE_NAME = "device_name";
  
  private static final String TAG = "DeviceListActivity";
  
  private int DiscoverCount = 0;
  
  private BluetoothAdapter mBtAdapter;
  
  private AdapterView.OnItemClickListener mDeviceClickListener = new AdapterView.OnItemClickListener() {
      public void onItemClick(AdapterView<?> param1AdapterView, View param1View, int param1Int, long param1Long) {
        DeviceListActivity.this.mBtAdapter.cancelDiscovery();
        String str2 = ((Custom2_Item)param1AdapterView.getAdapter().getItem(param1Int)).getData()[0];
        String str1 = ((Custom2_Item)param1AdapterView.getAdapter().getItem(param1Int)).getData()[1];
        Intent intent = new Intent();
        intent.putExtra(DeviceListActivity.EXTRA_DEVICE_ADDRESS, str1);
        intent.putExtra(DeviceListActivity.EXTRA_DEVICE_NAME, str2);
        DeviceListActivity.this.setResult(-1, intent);
        DeviceListActivity.this.finish();
      }
    };
  
  private CustomAdapter2 mDiscoveredAdapter;
  
  private CustomAdapter2 mPairedAdapter;
  
  private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
      public void onReceive(Context param1Context, Intent param1Intent) {
        BluetoothDevice bluetoothDevice;
        String str = param1Intent.getAction();
        if ("android.bluetooth.device.action.FOUND".equals(str)) {
          bluetoothDevice = (BluetoothDevice)param1Intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
          if (bluetoothDevice.getBondState() != 12) {
            String str1 = bluetoothDevice.getName();
            String str2 = bluetoothDevice.getAddress();
            if (bluetoothDevice.getName() != null) {
              Log.d("DeviceListActivity", "Discoverd Device : " + bluetoothDevice.getName() + " \n address : " + bluetoothDevice.getAddress());
              boolean bool2 = false;
              boolean bool1 = false;
              if (DeviceListActivity.this.mDiscoveredAdapter.getCount() != 0) {
                int i = 0;
                while (true) {
                  bool2 = bool1;
                  if (i < DeviceListActivity.this.mDiscoveredAdapter.getCount()) {
                    Custom2_Item custom2_Item = (Custom2_Item)DeviceListActivity.this.mDiscoveredAdapter.getItem(i);
                    String str3 = custom2_Item.getData()[0];
                    String str4 = custom2_Item.getData()[1];
                    Log.d("DeviceListActivity", "nameTemp : " + str3 + "\naddressTemp : " + str4);
                    bool2 = bool1;
                    if (str1.equals(str3)) {
                      bool2 = bool1;
                      if (str2.equals(str4))
                        bool2 = true; 
                    } 
                    i++;
                    bool1 = bool2;
                    continue;
                  } 
                  break;
                } 
              } 
              if (bool2) {
                Log.d("DeviceListActivity", "this device is already discovered");
              } else {
                if (DeviceListActivity.this.mDiscoveredAdapter.getCount() != 0 && ((Custom2_Item)DeviceListActivity.this.mDiscoveredAdapter.getItem(0)).getData()[0].equals("No device"))
                  DeviceListActivity.this.mDiscoveredAdapter.removeItem(); 
                DeviceListActivity.this.mDiscoveredAdapter.addItem(new Custom2_Item(DeviceListActivity.this.getResources().getDrawable(2130903055), bluetoothDevice.getName(), bluetoothDevice.getAddress()));
              } 
            } 
            DeviceListActivity.this.newDevicesListView.setAdapter((ListAdapter)DeviceListActivity.this.mDiscoveredAdapter);
            DeviceListActivity.this.newDevicesListView.setOnItemClickListener(DeviceListActivity.this.mDeviceClickListener);
            DeviceListActivity.this.newDevicesListView.setOnItemClickListener(DeviceListActivity.this.mDeviceClickListener);
          } 
          return;
        } 
        if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(bluetoothDevice)) {
          Log.d("DeviceListActivity", "finished " + bluetoothDevice);
          DeviceListActivity.this.doDiscovery();
          DeviceListActivity.this.setProgressBarIndeterminateVisibility(false);
          DeviceListActivity.this.setTitle(2131230760);
          if (DeviceListActivity.this.mDiscoveredAdapter.getCount() == 0) {
            DeviceListActivity.this.getResources().getText(2131230756).toString();
            DeviceListActivity.this.mDiscoveredAdapter.addItem(new Custom2_Item(DeviceListActivity.this.getResources().getDrawable(2130903052), "No device", ""));
            return;
          } 
        } 
      }
    };
  
  private ListView newDevicesListView;
  
  private void doDiscovery() {
    Log.d("DeviceListActivity", "doDiscovery()");
    setProgressBarIndeterminateVisibility(true);
    setTitle(2131230759);
    ((Button)findViewById(2131558498)).setVisibility(8);
    ((LinearLayout)findViewById(2131558496)).setVisibility(0);
    if (this.mBtAdapter.isDiscovering())
      this.mBtAdapter.cancelDiscovery(); 
    (new Thread(new Runnable() {
          public void run() {
            DeviceListActivity.this.mBtAdapter.startDiscovery();
            DeviceListActivity.access$208(DeviceListActivity.this);
            if (DeviceListActivity.this.DiscoverCount > 1) {
              DeviceListActivity.this.mDiscoveredAdapter.removeItem();
              DeviceListActivity.access$202(DeviceListActivity.this, 0);
            } 
          }
        })).start();
  }
  
  public void finish() {
    super.finish();
    overridePendingTransition(2131034124, 2131034122);
  }
  
  protected void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    getWindow().getDecorView().setSystemUiVisibility(4098);
    getIntent();
    setContentView(2130968604);
    setResult(0);
    ((Button)findViewById(2131558498)).setOnClickListener(new View.OnClickListener() {
          public void onClick(View param1View) {
            DeviceListActivity.this.doDiscovery();
            param1View.setVisibility(8);
          }
        });
    this.mPairedAdapter = new CustomAdapter2((Context)this);
    this.mDiscoveredAdapter = new CustomAdapter2((Context)this);
    ListView listView = (ListView)findViewById(2131558495);
    listView.setAdapter((ListAdapter)this.mPairedAdapter);
    listView.setOnItemClickListener(this.mDeviceClickListener);
    this.newDevicesListView = (ListView)findViewById(2131558497);
    IntentFilter intentFilter = new IntentFilter();
    intentFilter.addAction("android.bluetooth.device.action.FOUND");
    intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
    registerReceiver(this.mReceiver, intentFilter);
    this.mBtAdapter = BluetoothAdapter.getDefaultAdapter();
    Set set = this.mBtAdapter.getBondedDevices();
    if (set.size() > 0) {
      for (BluetoothDevice bluetoothDevice : set) {
        bluetoothDevice.getAddress();
        this.mPairedAdapter.addItem(new Custom2_Item(getResources().getDrawable(2130903055), bluetoothDevice.getName(), bluetoothDevice.getAddress()));
      } 
    } else {
      getResources().getText(2131230757).toString();
      this.mPairedAdapter.addItem(new Custom2_Item(getResources().getDrawable(2130903052), "no device", ""));
    } 
  }
  
  protected void onDestroy() {
    super.onDestroy();
    if (this.mBtAdapter != null)
      this.mBtAdapter.cancelDiscovery(); 
    unregisterReceiver(this.mReceiver);
  }
}


/* Location:              C:\Workspace\Handsons\Drone\original-drms-app-dex2jar.jar!\com\drms\drms_drone\Communication\ClassicBluetooth\DeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */