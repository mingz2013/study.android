package com.example.activity;



import android.os.Bundle;


/*
 * 
 * 
 * */
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	// ��������˽�г�Ա
	private TextView myTextView=null;
	private  Button myButton=null;
    @Override
    // ��д����
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);// ����
        
        // ͨ��ID�õ��ؼ�����
        myTextView = (TextView)findViewById(R.id.MyTextView);
        myButton = (Button)findViewById(R.id.MyButton);
        // �����ı�
        myTextView.setText("�ҵĵ�һ��textview");
        myButton.setText("�ҵĵ�һ��button");
        // ������������
        myButton.setOnClickListener(new MyButtonListener());
        
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
			intent.setClass(MainActivity.this, OtherActivity.class);
			// �� otheractivity
			MainActivity.this.startActivity(intent);
			
		}
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
