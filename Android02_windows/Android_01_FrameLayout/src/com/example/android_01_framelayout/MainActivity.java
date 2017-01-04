package com.example.android_01_framelayout;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends Activity {
	FrameLayout frameLayout = null;
	private boolean flag = true;
	
	public static final int SLEEP_TIME = 200;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		frameLayout = (FrameLayout)findViewById(R.id.frame);
		
		// 创建一个Handler子类对象，要调用其方法
		final MyHandler myHandler = new MyHandler();// 消息通讯类
		myHandler.sleep(SLEEP_TIME);
		//为frame设置点击事件，当其被点击事，在停止与启动之间变换
		frameLayout.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				flag = !flag;
				myHandler.sleep(SLEEP_TIME);
			}
		});
	}
	
	// 由该类两个方法间的循环调用，实现界面不断更新
	class MyHandler extends Handler{
		int i = 0;

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			i++;
			// 总共三幅图，依次显示
			show(i % 6);
			// 再次调用sleep方法
			sleep(SLEEP_TIME);
		}
		public void sleep(long delayMillis){
			// 判断是否继续飞翔
			if(flag){
				// 实质上是调用了一次handleMessage
				sendMessageDelayed(obtainMessage(0), delayMillis);// 本身延迟发送一个消息，就会调用heandlemessage
			}
		}
		// 该方法是被调用以更新帧布局的前景图片
		void show(int j){
			// 获取三张图片
			Drawable a = getResources().getDrawable(R.drawable.p1);
			Drawable b = getResources().getDrawable(R.drawable.p2);
			Drawable c = getResources().getDrawable(R.drawable.p3);
			Drawable d = getResources().getDrawable(R.drawable.p4);
			Drawable e = getResources().getDrawable(R.drawable.p5);
			Drawable f = getResources().getDrawable(R.drawable.p6);
			// 不同的情况设置不同的背景
			switch (j) {
			case 0:
				frameLayout.setForeground(a);
				break;
			case 1:
				frameLayout.setForeground(b);
				break;
			case 2:
				frameLayout.setForeground(c);
				break;
			case 3:
				frameLayout.setForeground(d);
				break;
			case 4:
				frameLayout.setForeground(e);
				break;
			case 5:
				frameLayout.setForeground(f);
				break;

			default:
				break;
			}
		}
	}

	

}
