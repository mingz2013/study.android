package com.example.autocompletetextview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
	private AutoCompleteTextView autoCompleteTextView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 新建变量
		autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.outocomplete);
		//1.在布局文件当中声明一个AutoCompleteTextView
		//2.在res/layout文件夹下新建一个布局文件，名为list_item.xml
		//3.创建一个ArrayAdapter来提供数据!DOCTYPE 动态创建
		List<String>list = new ArrayList<String>();
		list.add("testabc");
		list.add("testcde");
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, list);// 这里的list也可以传入一个字符串数组
		//4.为AutoCompleteTextView设置数据
		autoCompleteTextView.setAdapter(arrayAdapter);
	}



}
