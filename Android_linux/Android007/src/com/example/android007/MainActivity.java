package com.example.android007;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	EditText usernameEditText;
	EditText passwordEditText;
	Button nextButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		usernameEditText = (EditText)findViewById(R.id.usernameEditText);
		passwordEditText = (EditText)findViewById(R.id.passwordEditText);
		nextButton = (Button)findViewById(R.id.nextButton);
		nextButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String str_username = usernameEditText.getText().toString();
				String str_password = passwordEditText.getText().toString();
				Bundle bundle = new Bundle();
				bundle.putString("username", str_username);
				bundle.putString("password", str_password);
				
				Intent intent = new Intent(MainActivity.this, NextActivity.class);
				intent.putExtras(bundle);
				// 启动另一个activity并返回结果
				startActivityForResult(intent, 0);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
		Bundle bundle = data.getExtras();
		
		String str_username = bundle.getString("username");
		String str_password = bundle.getString("password");
		
		usernameEditText.setText(str_username);
		passwordEditText.setText(str_password);
		
		
		
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	
	
	

}
