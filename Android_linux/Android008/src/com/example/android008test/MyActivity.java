package com.example.android008test;

import com.example.android008.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MyActivity extends Activity{
	TextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
		textview = (TextView)findViewById(R.id.textView);
		
		Intent intent = getIntent();
		ComponentName cn = intent.getComponent();
		String packagename = cn.getPackageName();
		String classname = cn.getClassName();
		
		textview.setText("packagename:" + packagename + "\n classname:" + classname);
		
	}
	

}
