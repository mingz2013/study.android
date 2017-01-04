package com.example.animations05;




import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.View.OnClickListener;
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
			// ���ñ���ͼ��Դ
			imageView.setBackgroundResource(R.drawable.anim_nv);
			// ǿ������ת��
			AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
			// ����
			animationDrawable.start();
			
		}
		
	}


}
