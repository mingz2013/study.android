package com.example.activity;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreeActivity extends Activity{

	private Button threebutton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		
		threebutton=(Button)findViewById(R.id.button1);
		
		threebutton.setText(R.string.three);
		
		// 捆绑监听类对象
        threebutton.setOnClickListener(new MyButtonListener());
		
	}
	 class MyButtonListener implements OnClickListener{
	    	// 监听类，内部类
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				/*/ 生成一个Intent 对象
				Intent intent = new Intent();
				// 传递一个键值对,,,,可以在不同应用程序之间的activity传递数据
				intent.putExtra("testintent", "testintent");
				//设置类
				intent.setClass(ThreeActivity.this, MainActivity.class);
				// 打开 otheractivity
				ThreeActivity.this.startActivity(intent);
				*/
				Uri uri=Uri.parse("smsto://5556");
				Intent it = new Intent(Intent.ACTION_SENDTO,uri);
				it.putExtra("sms_body", "the sms text");
				startActivity(it);
				
				
				
			}
	 }

}
