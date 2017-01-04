package com.example.wifi;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity {
	private Button startButton = null;
	private Button stopButton = null;
	private Button checkButton = null;
	private WifiManager wifiManager = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.start);
		stopButton = (Button)findViewById(R.id.stop);
		checkButton = (Button)findViewById(R.id.check);
		startButton.setOnClickListener(new StartWifiListener());
		stopButton.setOnClickListener(new StopWifiListener());
		checkButton.setOnClickListener(new CheckWifiListener());
	}
	class StartWifiListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wifiManager = (WifiManager)MainActivity.this.getSystemService(Context.WIFI_SERVICE);
			wifiManager.setWifiEnabled(true);
			System.out.println("wifi state --->" + wifiManager.getWifiState());
			Toast.makeText(MainActivity.this, "当前网卡的状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();
			
		}
		
	}
	class StopWifiListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			wifiManager = (WifiManager)MainActivity.this.getSystemService(Context.WIFI_SERVICE);
			wifiManager.setWifiEnabled(false);
			System.out.println("wifi state --->" + wifiManager.getWifiState());
			Toast.makeText(MainActivity.this, "当前网卡的状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();
			
		}
		
	}
	class CheckWifiListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub000
			wifiManager = (WifiManager)MainActivity.this.getSystemService(Context.WIFI_SERVICE);
			System.out.println("wifi state --->" + wifiManager.getWifiState());
			Toast.makeText(MainActivity.this, "当前网卡的状态为" + wifiManager.getWifiState(), Toast.LENGTH_LONG).show();
			
		}
		
	}

	

}
