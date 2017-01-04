package com.example.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity{
	private Button startServiceButton = null;
	private Button stopServiceButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		startServiceButton = (Button)findViewById(R.id.startService);
		stopServiceButton = (Button)findViewById(R.id.stopService);
		startServiceButton.setOnClickListener(new StartServiceListener());
		stopServiceButton.setOnClickListener(new StopServiceListener());
		
		
	}
	class StartServiceListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, FirstService.class);
			startService(intent);
		}
		
	}
	class StopServiceListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, FirstService.class);
			stopService(intent);
			
		}
		
	}

}
