package com.example.android013;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	Button sendButton ;
	EditText receverEditText, theameEditText, contentEditText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		sendButton = (Button)findViewById(R.id.sendButton);
		receverEditText = (EditText)findViewById(R.id.receverEditText);
		theameEditText = (EditText)findViewById(R.id.theameEditText);
		contentEditText = (EditText)findViewById(R.id.contentEditText);
		
		sendButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String to = receverEditText.getText().toString();
				String theame = theameEditText.getText().toString();
				String content = contentEditText.getText().toString();
				// 创建intent
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				// 设置内容类型
				emailIntent.setType("plain/text");
				// 设置额外信息
				emailIntent.putExtra(Intent.EXTRA_EMAIL	, new String[]{to});
				emailIntent.putExtra(Intent.EXTRA_SUBJECT, theame);
				emailIntent.putExtra(Intent.EXTRA_TEXT, content);
				// 启动activity
				startActivity(Intent.createChooser(emailIntent, "发送邮件。。。"));
				
			}
		});
	}

	

}
