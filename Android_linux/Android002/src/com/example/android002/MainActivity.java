package com.example.android002;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final TextView textview = (TextView)findViewById(R.id.text1);
		final Button button1 = (Button)findViewById(R.id.button1);
		final Button button2 = (Button)findViewById(R.id.button2);
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textview.setBackgroundColor(Color.RED);
				
			}
		});
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				textview.setBackgroundColor(Color.GREEN);
				
			}
		});
		
		
		
	}

	

}
