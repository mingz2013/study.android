package com.example.animations04;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private ImageView imageView = null;
	private Button Button = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView)findViewById(R.id.imageViewId);
		Button = (Button)findViewById(R.id.buttonId);
		Button.setOnClickListener(new ButtonListener());
	}
	
	private class ButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			/*/ 使用AnimationUtils装载动画设置文件
			// 这里实际上里面有两个动画效果，应该是个animationSet，这里向上转型
			Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.alpha);
			// 在控件中执行动画
			imageView.startAnimation(animation);
			*/
			// 声明一个animationSet对象
			AnimationSet animationSet = new AnimationSet(true);
			AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
			RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
			animationSet.addAnimation(alphaAnimation);
			animationSet.addAnimation(rotateAnimation);
			animationSet.setDuration(2000);
			animationSet.setStartOffset(500);
			imageView.startAnimation(animationSet);
		}
		
	}

}
