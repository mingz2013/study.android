package com.example.seekbar;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;

public class MainActivity extends Activity {
	private SeekBar seekBar = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		seekBar = (SeekBar)findViewById(R.id.seekBarId);
		// ���øý����������ֵ
		seekBar.setMax(100);
		seekBar.setOnSeekBarChangeListener(new SeekBarListener());
	}
	// ����һ��������,�ü������������������״̬�ĸı�
	private class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

		@Override
		// ���������Ľ��ȷ����仯ʱ,����ø÷���
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			System.out.println(progress);
			
		}

		@Override
		// ���û���ʼ��������ʱ,���ø÷���
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			System.out.println("start--->" + seekBar.getProgress());
		}

		@Override
		// ���û������Ի���Ļ���ʱ,���ø÷���
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			System.out.println("stop-->" + seekBar.getProgress());
		}
		
	}
	

}
