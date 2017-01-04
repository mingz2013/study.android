package com.example.android003;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;


public class MainActivity extends Activity {
	
	private static final String TAG = "TestKeyEvent";
	private TextView textview ;
	private ImageView image;
	private int mAlphavalue;
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		textview = (TextView)findViewById(R.id.alphavalue);
		image = (ImageView)findViewById(R.id.image);
		mAlphavalue = 100;
		image.setAlpha(mAlphavalue);
		textview.setText("Alpha=" + mAlphavalue*100/0xff + "%");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	// 按键事件
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onKeyDown: keyCode = "+ keyCode);
		Log.v(TAG, "onKeyDown: String = " + event.toString());
		
		switch (keyCode) {
			case KeyEvent.KEYCODE_DPAD_UP:
				mAlphavalue += 20;
				break;
			case KeyEvent.KEYCODE_DPAD_RIGHT:
				mAlphavalue += 20;
				break;
			case KeyEvent.KEYCODE_DPAD_DOWN:
				mAlphavalue -= 20;
				break;
			case KeyEvent.KEYCODE_DPAD_LEFT:
				mAlphavalue -= 20;
				break;
			default:
				break;
		}
		if(mAlphavalue>=0xFF)
			mAlphavalue = 0xFF;
		if(mAlphavalue<=0x0)
			mAlphavalue = 0x0;
		image.setAlpha(mAlphavalue);
		textview.setText("Alpha = " + mAlphavalue*100/0xff + "%");
		
		return super.onKeyDown(keyCode, event);
	}
	
	



}
