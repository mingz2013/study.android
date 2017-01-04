package com.example.bluetooth01;

import java.util.Iterator;
import java.util.Set;
import android.os.Bundle;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.scanbuttonId);
		button.setOnClickListener(new ButtonListener());
	}
	private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// 得到BluetoothAdapter对象
			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
			// 判断bluetoothAdapter对象是否为空，如果为空，则表明本机没有蓝牙设备
			if(adapter != null){
				Toast.makeText(MainActivity.this, "本机拥有蓝牙设备", Toast.LENGTH_LONG).show();
				System.out.println("本机拥有蓝牙设备");
				// 调用isEnabled方法判断是否可用
				if(!adapter.isEnabled()){
					// 蓝牙不可用，则创建一个intent对象，用来启动一个Activity，提示用户开启蓝牙设备
					Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivity(intent);
				}
				// 得到所有的已配对的蓝牙适配器对象 ，并不是只有打开蓝牙才可以得到已配对的对象，即使不打开也可以查找到
				Set<BluetoothDevice> devices = adapter.getBondedDevices();
				if(devices.size() > 0){
					Toast.makeText(MainActivity.this, "devices.size() > 0", Toast.LENGTH_LONG).show();
					System.out.println("devices.size() > 0");
					for(Iterator iterator = devices.iterator(); iterator.hasNext();){
						BluetoothDevice bluetoothDevice = (BluetoothDevice)iterator.next();
						// 得到远程蓝牙设备的地址
						Toast.makeText(MainActivity.this, "------>" + bluetoothDevice.getAddress(), Toast.LENGTH_LONG).show();
						System.out.println("------>" + bluetoothDevice.getAddress());
					}
				}
				else{
					Toast.makeText(MainActivity.this, "devices.size() < 0", Toast.LENGTH_LONG).show();
					System.out.println("devices.size() < 0");
				}
			}else{
				Toast.makeText(MainActivity.this, "没有蓝牙设备", Toast.LENGTH_LONG).show();
				System.out.println("没有蓝牙设备");
			}
		}
		
	}

	

}
