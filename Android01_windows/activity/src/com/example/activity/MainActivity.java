package com.example.activity;



import android.os.Bundle;


/*
 * 
 * 
 * */
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	// 声明两个私有成员
	private TextView myTextView=null;
	private  Button myButton=null;
    @Override
    // 复写方法
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// 设置
        
        // 通过ID得到控件变量
        myTextView = (TextView)findViewById(R.id.MyTextView);
        myButton = (Button)findViewById(R.id.MyButton);
        // 设置文本
        myTextView.setText("我的第一个textview");
        myButton.setText("我的第一个button");
        // 捆绑监听类对象
        myButton.setOnClickListener(new MyButtonListener());
        
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
			intent.setClass(MainActivity.this, OtherActivity.class);
			// 打开 otheractivity
			MainActivity.this.startActivity(intent);
			
		}
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
