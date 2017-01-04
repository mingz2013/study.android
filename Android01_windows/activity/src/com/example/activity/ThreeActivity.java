package com.example.activity;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ThreeActivity extends Activity{

	private Button threebutton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_three);
		
		threebutton=(Button)findViewById(R.id.button1);
		
		threebutton.setText(R.string.three);
		
		// ������������
        threebutton.setOnClickListener(new MyButtonListener());
		
	}
	 class MyButtonListener implements OnClickListener{
	    	// �����࣬�ڲ���
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				/*/ ����һ��Intent ����
				Intent intent = new Intent();
				// ����һ����ֵ��,,,,�����ڲ�ͬӦ�ó���֮���activity��������
				intent.putExtra("testintent", "testintent");
				//������
				intent.setClass(ThreeActivity.this, MainActivity.class);
				// �� otheractivity
				ThreeActivity.this.startActivity(intent);
				*/
				Uri uri=Uri.parse("smsto://5556");
				Intent it = new Intent(Intent.ACTION_SENDTO,uri);
				it.putExtra("sms_body", "the sms text");
				startActivity(it);
				
				
				
			}
	 }

}
