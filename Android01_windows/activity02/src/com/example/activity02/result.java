package com.example.activity02;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
/*
 * ���Ƚ��մ��ݹ�����ֵ
 * ��������ֵ�Ļ�
 * ������Ľ����ʾ��activity
 * */
public class result extends Activity{
	private TextView resultView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
	resultView=(TextView)findViewById(R.id.result);
		
		Intent intent = getIntent();
		// �õ�Intent�����е�ֵ
		String factorOneStr = intent.getStringExtra("one");
		String factorTwoStr = intent.getStringExtra("two");
		// ����ת��
		int factorOneInt = Integer.parseInt(factorOneStr);
		int factorTwoInt = Integer.parseInt(factorTwoStr);
		// ������  ��
		int result = factorOneInt * factorTwoInt;
		resultView.setText(result + "");// ���ͼӸ����ַ��� ת�����ַ���
		
	}

}
