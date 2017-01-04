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
 * 1.在activity03中添加4个控件
 * 2.添加显示的值
 * 3.创建一个监听器类，监听按钮按下的动作
 * 4.将监听类的对象绑定在按钮控件上
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
        
     // 根据控件的ID来取得代表控件的对象
        factorOne=(EditText)findViewById(R.id.factorOne);
        factorTwo=(EditText)findViewById(R.id.factorTwo);
        symbol=(TextView)findViewById(R.id.symbol);
        calculate=(Button)findViewById(R.id.calculate);
        
        // 为symbol和calculate设置显示的值
        //symbol.setText("乘以");
        //calculate.setText("计算");			这种方法不灵活
        symbol.setText(R.string.symbol);	//这样比较好，灵活
        calculate.setText(R.string.calculate);
        
        // 为按钮绑定监听器
        calculate.setOnClickListener(new CalculateListener());
        
    }
    class CalculateListener implements OnClickListener{
    	// 监听类
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			// 取得两个Editext控件的值
			String factorOneStr = factorOne.getText().toString();
			String factorTwoStr = factorTwo.getText().toString();
			// 将这两个值存放在Intent对象中
			Intent intent = new Intent();
			intent.putExtra("one", factorOneStr);
			intent.putExtra("two", factorTwoStr);
			intent.setClass(MainActivity.this, result.class);
			// 使用这个Intent对象来启动ResultActivity
			//MainActivity.this.startActivity(intent);
			MainActivity.this.startActivity(intent);
		}
    }





	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// 回调函数，当客户点击menu按钮的时候 调用该方法，
		// 菜单中添加两项
    	menu.add(0, 1, 1, R.string.exit);
    	menu.add(0, 2, 2, R.string.about);
		return super.onCreateOptionsMenu(menu);
	}





	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		// 回调函数，当客户点击菜单当中的某一个选项时会调用该方法，并把点击的项作为参数传递进来
		if(item.getItemId() == 1){
			finish();
			}
		return super.onOptionsItemSelected(item);
	}
    
}
