package com.example.android016;

import android.os.Bundle;
import android.os.IBinder;
import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button startButton, stopButton, bindButton, unbindButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.startbutton);
		stopButton = (Button)findViewById(R.id.stopbutton);
		bindButton = (Button)findViewById(R.id.bindbutton);
		unbindButton = (Button)findViewById(R.id.unbindbutton);
		startButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("com.example.android016.MY_SERVICE");
				startService(intent);
				
			}
		});
		stopButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("com.example.android016.MY_SERVICE");
				stopService(intent);
				
			}
		});
		
		bindButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("com.example.android016.MY_SERVICE");
				bindService(intent, conn, Service.BIND_AUTO_CREATE);
				
			}
		});
		unbindButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("com.example.android016.MY_SERVICE");
				unbindService(conn);
				
			}
		});
	}
	// 联接对象
	private ServiceConnection conn = new ServiceConnection() {
				
		@Override// 断开时用
		public void onServiceDisconnected(ComponentName arg0) {
			// TODO Auto-generated method stub
			Log.i("SERVICE", "联接成功！");
			Toast.makeText(MainActivity.this, "联接成功", Toast.LENGTH_LONG).show();
		}
		@Override// 联接时用
		public void onServiceConnected(ComponentName arg0, IBinder arg1) {
			// TODO Auto-generated method stub
			Log.i("SERVICE", "断开联接！");
			Toast.makeText(MainActivity.this, "断开联接", Toast.LENGTH_LONG).show();
		}
	};



}
