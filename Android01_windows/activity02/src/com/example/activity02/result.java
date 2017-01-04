package com.example.activity02;





import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
/*
 * 首先接收传递过来的值
 * 计算两个值的积
 * 将计算的结果显示在activity
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
		// 得到Intent对象当中的值
		String factorOneStr = intent.getStringExtra("one");
		String factorTwoStr = intent.getStringExtra("two");
		// 类型转换
		int factorOneInt = Integer.parseInt(factorOneStr);
		int factorTwoInt = Integer.parseInt(factorTwoStr);
		// 计算结果  积
		int result = factorOneInt * factorTwoInt;
		resultView.setText(result + "");// 整型加个空字符串 转换成字符串
		
	}

}
