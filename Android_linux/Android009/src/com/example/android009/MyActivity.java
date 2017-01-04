package com.example.android009;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends  Activity{
	TextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		textview = (TextView)findViewById(R.id.textview);
		
		Intent intent = getIntent();
		// 获取action
		String action = intent.getAction();
		textview.setText(action);
	}
	

}
