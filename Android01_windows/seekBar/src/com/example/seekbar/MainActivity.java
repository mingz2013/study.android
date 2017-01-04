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
		// 设置该进度条的最大值
		seekBar.setMax(100);
		seekBar.setOnSeekBarChangeListener(new SeekBarListener());
	}
	// 定义一个监听器,该监听器负责监听进度条状态的改变
	private class SeekBarListener implements SeekBar.OnSeekBarChangeListener{

		@Override
		// 当进度条的进度发生变化时,会调用该方法
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			// TODO Auto-generated method stub
			System.out.println(progress);
			
		}

		@Override
		// 当用户开始滑动滑块时,调用该方法
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			System.out.println("start--->" + seekBar.getProgress());
		}

		@Override
		// 当用户结束对滑块的滑动时,调用该方法
		public void onStopTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			System.out.println("stop-->" + seekBar.getProgress());
		}
		
	}
	

}
