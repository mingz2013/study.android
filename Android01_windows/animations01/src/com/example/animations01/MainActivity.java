package com.example.animations01;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

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
			AnimationSet animationSet = new AnimationSet(true);
			RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_PARENT, 1f, Animation.RELATIVE_TO_PARENT, 0f);
			rotateAnimation.setDuration(1000);
			animationSet.addAnimation(rotateAnimation);
			imageView.setAnimation(animationSet);
			
		}
		
	}
	private class ScaleButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			AnimationSet animationSet = new AnimationSet(true);
			ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.1f, 1, 0.1f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
			animationSet.addAnimation(scaleAnimation);
			animationSet.setDuration(2000);
			imageView.startAnimation(animationSet);
			
			
		}
		
	}
	private class AlphaButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// ����һ��AnimationSet����һ������
			AnimationSet animationSet = new AnimationSet(true);
			// ����һ��AlphaAnimation����
			AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);
			// ��һ������ִ�е�ʱ�䣬��λ����
			alphaAnimation.setDuration(1000);
			// �Ѵ����õ�AlphaAnimation������ӵ�animationSet����
			animationSet.addAnimation(alphaAnimation);
			// ʹ��imageView��StartAnimation������ʼִ��
			imageView.startAnimation(animationSet);
			
		}
		
	}
	private class TranslatebuttonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			AnimationSet animationSet = new AnimationSet(true);
			TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0f, Animation.RELATIVE_TO_SELF, 1.0f);
			translateAnimation.setDuration(1000);
			animationSet.addAnimation(translateAnimation);
			imageView.startAnimation(animationSet);
			
		}
		
	}
	
	
}
