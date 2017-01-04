package com.example.android004;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
	private Button button2; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		button2 = (Button)findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();// 建立 Intent
				intent.setClass(SecondActivity.this, MainActivity.class);// 设置活动
				startActivity(intent);
				finish();// 结束当前活动
			}
		});
		
	}

	

}
