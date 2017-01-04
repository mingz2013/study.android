package com.example.android007;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NextActivity extends Activity{
	Button lastButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		lastButton = (Button)findViewById(R.id.lastButton);
		lastButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 获取Intent
				Intent intent = getIntent();
				// 设置返回结果
				NextActivity.this.setResult(0, intent);
				// 结束当前activity
				NextActivity.this.finish();
			}
		});
	}
	
}
