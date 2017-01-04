package com.example.animations07;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout.LayoutParams;
import android.app.Activity;

public class MainActivity extends Activity {
	private Button removeButton = null;
	private Button addButton = null;
	private ImageView imageView = null;
	private ViewGroup viewGroup = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		removeButton = (Button)findViewById(R.id.removeButtonId);
		addButton = (Button)findViewById(R.id.addButtonId);
		imageView = (ImageView)findViewById(R.id.imageViewId);
		// viewGroup包含了所有的控件
		viewGroup = (ViewGroup)findViewById(R.id.layoutId);
		
		addButton.setOnClickListener(new AddButtonListener());
		removeButton.setOnClickListener(new RemoveButtonListener());
		
	}
	private class AddButtonListener implements OnClickListener{

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// 创建了一个淡入效果的Animation
			// TODO Auto-generated method stub
			AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
			animation.setDuration(1000);
			animation.setStartOffset(500);
			// 创建一个ImageView
			ImageView imageViewAdd = new ImageView(MainActivity.this);
			imageViewAdd.setImageResource(R.drawable.ic_launcher);
			// 添加
			viewGroup.addView(imageViewAdd, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));
			// 启动动画
			imageViewAdd.startAnimation(animation);
			
		}
		
	}
	private class RemoveButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// 创建一个淡出效果的Animation对象
			AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
			// 设置属性
			animation.setDuration(1000);
			animation.setStartOffset(500);
			// 设置监听器
			animation.setAnimationListener(new RemoveAnimationListener());
			imageView.startAnimation(animation);
			
		}
		
	}
	private class RemoveAnimationListener implements AnimationListener{

		@Override
		public void onAnimationEnd(Animation animation) {
			// TODO Auto-generated method stub
			System.out.println("end");
			// 删除掉Imageview
			viewGroup.removeView(imageView);
			
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			// TODO Auto-generated method stub
			System.out.println("repeat");
			
		}

		@Override
		public void onAnimationStart(Animation animation) {
			// TODO Auto-generated method stub
			System.out.println("start");
			
		}
		
	}

	

}
