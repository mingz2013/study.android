package com.example.android_02_client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends Activity{
	private EditText usernameRegisterEditText;
	private EditText passwordRegister1EditText;
	private EditText passwordRegister2EditText;
	private Button registerPostButton;
	private Button registerReturnButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		usernameRegisterEditText = (EditText)findViewById(R.id.editText_username_register);
		passwordRegister1EditText = (EditText)findViewById(R.id.editText_password_register1);
		passwordRegister2EditText = (EditText)findViewById(R.id.editText_password_register2);
		registerPostButton = (Button)findViewById(R.id.button_Register_Post);
		registerReturnButton = (Button)findViewById(R.id.button_Register_Return);
		registerPostButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		registerReturnButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
				startActivity(intent);
				//System.exit(0);
			}
		});
	}
	

}
