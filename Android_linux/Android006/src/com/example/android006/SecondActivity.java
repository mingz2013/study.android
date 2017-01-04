package com.example.android006;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class SecondActivity extends Activity{
	TextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		textview = (TextView)findViewById(R.id.textView02);
		// 获得intent
		Intent intent = getIntent();
		// 从Intent中获取Bundle对象
		Bundle bundledata = intent.getExtras();
		// 从bundle中获取name
		String name = bundledata.getString("name");
		
		// 创建查询列数组
		String[] projection = new String[] {People._ID, People.NAME, People.NUMBER};
		// 查询Uri对象
		
		Uri contacts = People.CONTENT_URI;
		// 查询参数
		String[] args = {name};
		// 根据姓名查询联系人
		
		Cursor managedCursor = managedQuery(contacts, projection, "name=?", args, People.NAME + " ASC");
		// 便利游标
		if(managedCursor.moveToFirst()){
			// 获得姓名
			String name1 = managedCursor.getString(1);
			// 获得电话号码
			String number = managedCursor.getString(2);
			// 显示姓名和号码
			textview.setText(name1 + ":" + number);
		}
		
		//textview.setText(name);
	}
	
}
