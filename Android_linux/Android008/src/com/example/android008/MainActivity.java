package com.example.android008;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;

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
				// 实例化组建名称
				ComponentName cn = new ComponentName(MainActivity.this, "com.example.android008test.MyActivity");
				Intent intent = new Intent();
				// 为intent设置组建名称属性
				intent.setComponent(cn);
				startActivity(intent);
			}
		});
	}

	

}
