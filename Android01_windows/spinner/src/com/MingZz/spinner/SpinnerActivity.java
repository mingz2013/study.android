package com.MingZz.spinner;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerActivity extends Activity {
	private Spinner spinner = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		spinner = (Spinner)findViewById(R.id.spinnerId);
		/**动态创建ArrayAdapter
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		/**调用ArrayAdapter的构造函数来创建 ArrayAdapter对象
		 * 第一个参数指的是上下文对象
		 * 第二个参数制定了上下文菜单中每一个条目的样式，这里我们用自己写的一个布局文件
		 * 第三个参数制定了textView控件的ID，
		 * 第四个参数指定了整个列表的数据，list中可以加任何对象，他会把list对象中的内容调用toString()方法得到的字符串显示在textView中
		ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, R.id.textViewId, list);
		*/
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(// 创建一个ArrayAdapter对象
				this, 
				R.array.planets_array,	// string.xml中定义的数组，数据来源
				android.R.layout.simple_spinner_item	//布局文件，android自带的，默认的下拉菜单样式，也可替换为自己定义的布局文件
				);
		adapter.setDropDownViewResource(// 设置下拉菜单中每一个条目的样式
				android.R.layout.simple_spinner_dropdown_item	// android自带的布局文件，定义每一个选项的样式
				);
		spinner.setAdapter(adapter);
		spinner.setPrompt("测试");	// 设置标题
		// 绑定监听器
		spinner.setOnItemSelectedListener(new SpinnerOnSelectedListener());
		
		
	}
	// 创建一个监听器
	class SpinnerOnSelectedListener implements OnItemSelectedListener{

		// 当用户选中某一条目时，会调用这个方法
		public void onItemSelected(AdapterView<?> adapterView, View view, int position,
				long id) {
			// 得到选中的文本数据
			String selected = adapterView.getItemAtPosition(position).toString();
			System.out.println(selected);
			
		}

		@Override// 用户什么都没选
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			System.out.println("nothingSelected");
			
		}
		
	}

	

}
