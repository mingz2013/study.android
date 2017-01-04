package com.example.android017;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	Button button;
	private static final String MY_ACTION = "com.example.android017.MY_ACTION";
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
				intent.setAction(MY_ACTION);
				intent.putExtra("msg", "地瓜，地瓜，我是土豆，收到清回复！！");
				sendBroadcast(intent);
			}
		});
		
		
	}

	

}
