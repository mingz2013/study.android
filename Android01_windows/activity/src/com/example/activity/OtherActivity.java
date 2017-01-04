package com.example.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity{

	private TextView otherTextView=null;
	private  Button otherButton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// 设置
		setContentView(R.layout.activity_other);
		// 获取传送的Intent
		Intent intent=getIntent();
		// 获取对应的键值
		String value=intent.getStringExtra("testintent");
		
		otherTextView = (TextView)findViewById(R.id.OtherTextView);
	    otherButton = (Button)findViewById(R.id.OtherButton);
	       
		otherTextView.setText("对话框风格");
		otherButton.setText(value);
		
		
		 otherButton.setOnClickListener(new MyButtonListener());
		
	}
	
	 class MyButtonListener implements OnClickListener{
	    	// 监听类，内部类
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// 生成一个Intent 对象
				Intent intent = new Intent();
				// 传递一个键值对,,,,可以在不同应用程序之间的activity传递数据
				intent.putExtra("testintent", "testintent");
				//设置类
				intent.setClass(OtherActivity.this, ThreeActivity.class);
				// 打开 otheractivity
				OtherActivity.this.startActivity(intent);
				finish();// 销毁，返回时 不再显示这个activity，而是直接跳到第一个
			}  
	 }
	

}
