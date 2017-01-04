package com.example.android004;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();// 建立 Intent
				intent.setClass(MainActivity.this, SecondActivity.class);// 设置活动
				startActivity(intent);
				finish();// 结束当前活动
				
			}
		});
	}



}
