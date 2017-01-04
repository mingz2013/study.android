package com.example.bluetooth02;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MainActivity extends Activity {
	private Button discoverButton = null;
	private Button scanButton = null;
	private BluetoothAdapter bluetoothAdapter = null;
	private BluetoothReceiver bluetoothReceiver = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		discoverButton = (Button)findViewById(R.id.discoverButtonId);
		scanButton = (Button)findViewById(R.id.scanButtonId);
		
		discoverButton.setOnClickListener(new DiscoverButtonListener());
		scanButton.setOnClickListener(new Scanbutton());
		// ����һ��intentFilter���󣬽���actionָ��ΪBluetoothDevice.ACTION_FOUND
		IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		bluetoothReceiver = new BluetoothReceiver();
		// ע��㲥������
		registerReceiver(bluetoothReceiver, intentFilter);
		bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		
		
	}
	private class BluetoothReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			String action = intent.getAction();
			if(BluetoothDevice.ACTION_FOUND.equals(action)){
				// ������յ���Intent�����У�������Զ�̵�����������ȡ��
				BluetoothDevice bluetoothDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				// �õ���mac��ַ
				System.out.println(bluetoothDevice.getAddress());
				Toast.makeText(MainActivity.this, bluetoothDevice.getAddress(), Toast.LENGTH_LONG).show();
			}
			
		}
		
	}
	// �ü����������޸������ɼ���
	private class DiscoverButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// ����һ��Intent���󣬲�����action��ֵ����ΪBluetoothAdapter��ACTION_REQUEST_DISCOVERABLE
			Intent discoverableIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
			// ��һ����ֵ�Դ�ŵ�Intent�����У���Ҫ����ָ���ɼ�״̬�ĳ���ʱ��
			discoverableIntent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 500);
			// ����һ��Activity��ϵͳ�ڲ���һ��activity
			startActivity(discoverableIntent);
			
		}
		
	}
	private class Scanbutton implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bluetoothAdapter.startDiscovery();// ����ᷢ��һ���㲥
			
		}
		
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		unregisterReceiver(bluetoothReceiver);
		super.onDestroy();
	}

	

}