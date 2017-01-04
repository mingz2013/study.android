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
			// �õ�BluetoothAdapter����
			BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
			// �ж�bluetoothAdapter�����Ƿ�Ϊ�գ����Ϊ�գ����������û�������豸
			if(adapter != null){
				Toast.makeText(MainActivity.this, "����ӵ�������豸", Toast.LENGTH_LONG).show();
				System.out.println("����ӵ�������豸");
				// ����isEnabled�����ж��Ƿ����
				if(!adapter.isEnabled()){
					// ���������ã��򴴽�һ��intent������������һ��Activity����ʾ�û����������豸
					Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
					startActivity(intent);
				}
				// �õ����е�����Ե��������������� ��������ֻ�д������ſ��Եõ�����ԵĶ��󣬼�ʹ����Ҳ���Բ��ҵ�
				Set<BluetoothDevice> devices = adapter.getBondedDevices();
				if(devices.size() > 0){
					Toast.makeText(MainActivity.this, "devices.size() > 0", Toast.LENGTH_LONG).show();
					System.out.println("devices.size() > 0");
					for(Iterator iterator = devices.iterator(); iterator.hasNext();){
						BluetoothDevice bluetoothDevice = (BluetoothDevice)iterator.next();
						// �õ�Զ�������豸�ĵ�ַ
						Toast.makeText(MainActivity.this, "------>" + bluetoothDevice.getAddress(), Toast.LENGTH_LONG).show();
						System.out.println("------>" + bluetoothDevice.getAddress());
					}
				}
				else{
					Toast.makeText(MainActivity.this, "devices.size() < 0", Toast.LENGTH_LONG).show();
					System.out.println("devices.size() < 0");
				}
			}else{
				Toast.makeText(MainActivity.this, "û�������豸", Toast.LENGTH_LONG).show();
				System.out.println("û�������豸");
			}
		}
		
	}

	

}
