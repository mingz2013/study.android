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
			handler.post(updateThread);// ���߳����ϼ��뵽��Ϣ���е���ȥ,����ִ��run����
		}
	}
	class EndButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			handler.removeCallbacks(updateThread);// �Ƴ��ص��Ľӿ�,�̲߳���ִ��
		}
	}
	// ����һ��Handler����
	Handler handler = new Handler();// �첽����Ϣ����
	// ��Ҫִ�еĲ���д���̶߳����run������
	Runnable updateThread = new Runnable() {// ʵ��һ���߳���
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("UpdateThread");
			//��run���������ٴε����߳�
			handler.postDelayed(updateThread, 3000);// ��3000�����Ժ�,���̼߳��뵽��Ϣ����,
		}
	};


}
