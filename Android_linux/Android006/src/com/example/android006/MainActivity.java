package com.example.android006;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	EditText editText;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText)findViewById(R.id.editText01);
		button = (Button)findViewById(R.id.button01);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 获取姓名字符串
				String name = editText.getText().toString();
				// 实例化bundle对象
				Bundle bundledata = new Bundle();
				// 将姓名信息添加到Bundle中
				bundledata.putString("name", name);
				// 创建Intent对象
				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				// 为intent添加bundle
				intent.putExtras(bundledata);
				startActivity(intent);
				
			}
		});
	}

	

}
