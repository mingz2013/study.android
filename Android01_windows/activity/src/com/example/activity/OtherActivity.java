package com.example.activity;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class OtherActivity extends Activity{

	private TextView otherTextView=null;
	private  Button otherButton=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ����
		setContentView(R.layout.activity_other);
		// ��ȡ���͵�Intent
		Intent intent=getIntent();
		// ��ȡ��Ӧ�ļ�ֵ
		String value=intent.getStringExtra("testintent");
		
		otherTextView = (TextView)findViewById(R.id.OtherTextView);
	    otherButton = (Button)findViewById(R.id.OtherButton);
	       
		otherTextView.setText("�Ի�����");
		otherButton.setText(value);
		
		
		 otherButton.setOnClickListener(new MyButtonListener());
		
	}
	
	 class MyButtonListener implements OnClickListener{
	    	// �����࣬�ڲ���
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				// ����һ��Intent ����
				Intent intent = new Intent();
				// ����һ����ֵ��,,,,�����ڲ�ͬӦ�ó���֮���activity��������
				intent.putExtra("testintent", "testintent");
				//������
				intent.setClass(OtherActivity.this, ThreeActivity.class);
				// �� otheractivity
				OtherActivity.this.startActivity(intent);
				finish();// ���٣�����ʱ ������ʾ���activity������ֱ��������һ��
			}  
	 }
	

}
