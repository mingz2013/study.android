package com.example.android014;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button;
	private static final String ACTION1 = "com.example.android014.TEST_ACTION1";
	private static final String ACTION2 = "com.example.android014.TEST_ACTION2";
	private static final String ACTION3 = "com.example.android014.TEST_ACTION3";
	private static final String CATEGORY1 = "com.example.android014.CATEGORY1"; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		button = (Button)findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				
				//intent.setAction(ACTION1);
				
				Uri data = Uri.parse("content://com.example.android014/abc");
				intent.setData(data);
				
				intent.addCategory(CATEGORY1);
				
				startActivity(intent);
				
			}
		});
	}

	

}
