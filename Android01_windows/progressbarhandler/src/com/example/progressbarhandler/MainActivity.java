package com.example.progressbarhandler;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.app.Activity;


public class MainActivity extends Activity {

	private ProgressBar bar = null;
	private Button startButton = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bar = (ProgressBar)findViewById(R.id.bar);
		startButton = (Button)findViewById(R.id.startButton);
		startButton.setOnClickListener(new StartButtonListener());
		
	}

	class StartButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			bar.setVisibility(View.VISIBLE);// ����Ϊ�ɼ�
			updateBarHandler.post(updateThread);// �����߳�
		}
		
	}
	// ʹ�������ڲ�������дhandler���е�   handleMessage   ����
	Handler updateBarHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			//super.handleMessage(msg);
			bar.setProgress(msg.arg1);
			// ���߳�ѹ�뵽�̶߳�����ȥ
			updateBarHandler.post(updateThread);
		}
		
	};
	//���߳��࣬����ʹ�������ڲ���ķ�ʽ��������
	Runnable updateThread = new Runnable() {
		int i = 0;
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Begin THread");
			i = i + 10;
			// �õ�һ����Ϣ����Message������android����ϵͳ�ṩ��
			Message msg = updateBarHandler.obtainMessage();
			// ��msg�����arg1������ֵ����Ϊi��
			// ��arg1��arg2����������������Ϣ��
			// �ŵ���ϵͳ�������Ľ���
			msg.arg1 = i;
			try{
				// ���õ�ǰ�߳�˯��1��
				Thread.sleep(1000);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
			// ����һ����Ϣ����Ϣ����msg���뵽��Ϣ�����У�
			updateBarHandler.sendMessage(msg);
			if(i == 100)
			{
				// �����i��ֵΪ100ʱ���ͽ��̶߳����handler�����Ƴ�
				updateBarHandler.removeCallbacks(updateThread);
			}
		}
	};

}