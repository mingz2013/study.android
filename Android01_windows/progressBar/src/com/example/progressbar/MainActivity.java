package com.example.progressbar;


import android.app.Activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	private ProgressBar firstBar = null;
	private ProgressBar secondBar = null;
	private Button myButton = null;
	private int i = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		firstBar = (ProgressBar)findViewById(R.id.firstBar);
		secondBar = (ProgressBar)findViewById(R.id.secondBar);
		myButton = (Button)findViewById(R.id.myButton);
		
		myButton.setOnClickListener(new ButtonListener());
	}
	
	class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(i == 0)
			{
				firstBar.setVisibility(View.VISIBLE);// 设置可见属性为  可见
				secondBar.setVisibility(View.VISIBLE);
			}
			else if( i < firstBar.getMax())
			{
				firstBar.setProgress(i);// 设置 主进度为i
				firstBar.setSecondaryProgress(i + 10); // 设置第二进度
				secondBar.setProgress(i);
			}
			else
			{
				firstBar.setVisibility(View.GONE);// 设置可见属性为  不可见
				secondBar.setVisibility(View.GONE);
			}
			i = i + 10;
		}
		
	}

	
}
