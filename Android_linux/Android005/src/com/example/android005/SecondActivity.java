package com.example.android005;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends Activity{
	TextView textview;
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
        textview = (TextView)findViewById(R.id.TextView02);
        button = (Button)findViewById(R.id.Button02);
 button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
	

}
