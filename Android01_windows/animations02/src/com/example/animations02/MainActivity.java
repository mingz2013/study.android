package com.example.animations02;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.app.Activity;

public class MainActivity extends Activity {
	private ImageView imageView = null;
	private Button rotateButton = null;
	private Button scaleButton = null;
	private Button alphaButton = null;
	private Button translateButton = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView)findViewById(R.id.imageViewId);
		rotateButton = (Button)findViewById(R.id.rotatebuttonId);
		rotateButton.setOnClickListener(new RoateButtonListener());
		scaleButton = (Button)findViewById(R.id.scalebuttonId);
		scaleButton.setOnClickListener(new ScaleButtonListener());
		alphaButton = (Button)findViewById(R.id.alphabuttonId);
		alphaButton.setOnClickListener(new AlphaButtonListener());
		translateButton = (Button)findViewById(R.id.translatebuttonId);
		translateButton.setOnClickListener(new TranslatebuttonListener());
	}
	private class RoateButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotate);
			imageView.startAnimation(animation);
			
		}
		
	}
	private class ScaleButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.sacle);
			imageView.startAnimation(animation);
			
			
		}
		
	}
	private class AlphaButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// 使用AnimationUtils装载动画设置文件
			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
			// 在控件中执行动画
			imageView.startAnimation(animation);
			
		}
		
	}
	private class TranslatebuttonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate);
			imageView.startAnimation(animation);
			
		}
		
	}

	

}
