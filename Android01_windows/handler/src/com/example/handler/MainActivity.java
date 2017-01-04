package com.example.handler;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;

public class MainActivity extends Activity {

	private Button startButton = null;
	private Button endButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		startButton = (Button)findViewById(R.id.startButton);
		endButton = (Button)findViewById(R.id.endButton);
		startButton.setOnClickListener(new StartButtonListener());
		endButton.setOnClickListener(new EndButtonListener());
		
	}
	class StartButtonListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			handler.post(updateThread);// 将线程马上加入到消息队列当中去,马上执行run函数
		}
	}
	class EndButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			handler.removeCallbacks(updateThread);// 移除回调的接口,线程不再执行
		}
	}
	// 创建一个Handler对象
	Handler handler = new Handler();// 异步的消息处理
	// 将要执行的操作写在线程对象的run方法里
	Runnable updateThread = new Runnable() {// 实现一个线程类
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("UpdateThread");
			//在run方法里面再次调用线程
			handler.postDelayed(updateThread, 3000);// 过3000毫秒以后,将线程加入到消息队列,
		}
	};


}
