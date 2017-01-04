package com.example.activity02;





import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
/*
 * 1.��activity03�����4���ؼ�
 * 2.�����ʾ��ֵ
 * 3.����һ���������࣬������ť���µĶ���
 * 4.��������Ķ�����ڰ�ť�ؼ���
 * */
public class MainActivity extends Activity {

	private EditText factorOne;
	private EditText factorTwo;
	private TextView symbol;
	private Button calculate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
     // ���ݿؼ���ID��ȡ�ô���ؼ��Ķ���
        factorOne=(EditText)findViewById(R.id.factorOne);
        factorTwo=(EditText)findViewById(R.id.factorTwo);
        symbol=(TextView)findViewById(R.id.symbol);
        calculate=(Button)findViewById(R.id.calculate);
        
        // Ϊsymbol��calculate������ʾ��ֵ
        //symbol.setText("����");
        //calculate.setText("����");			���ַ��������
        symbol.setText(R.string.symbol);	//�����ȽϺã����
        calculate.setText(R.string.calculate);
        
        // Ϊ��ť�󶨼�����
        calculate.setOnClickListener(new CalculateListener());
        
    }
    class CalculateListener implements OnClickListener{
    	// ������
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// ȡ������Editext�ؼ���ֵ
			String factorOneStr = factorOne.getText().toString();
			String factorTwoStr = factorTwo.getText().toString();
			// ��������ֵ�����Intent������
			Intent intent = new Intent();
			intent.putExtra("one", factorOneStr);
			intent.putExtra("two", factorTwoStr);
			intent.setClass(MainActivity.this, result.class);
			// ʹ�����Intent����������ResultActivity
			//MainActivity.this.startActivity(intent);
			MainActivity.this.startActivity(intent);
		}
    }





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// �ص����������ͻ����menu��ť��ʱ�� ���ø÷�����
		// �˵����������
    	menu.add(0, 1, 1, R.string.exit);
    	menu.add(0, 2, 2, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}





	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// �ص����������ͻ�����˵����е�ĳһ��ѡ��ʱ����ø÷��������ѵ��������Ϊ�������ݽ���
		if(item.getItemId() == 1){
			finish();
			}
		return super.onOptionsItemSelected(item);
	}
    
}
