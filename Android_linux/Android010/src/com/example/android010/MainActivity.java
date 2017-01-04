package com.example.android010;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				// 设置action属性
				intent.setAction(Intent.ACTION_GET_CONTENT);
				// 设置type属性
				intent.setType("vnd.android.cursor.item/phone");
				startActivity(intent);
				
			}
		});
		
		
		
	}



}
