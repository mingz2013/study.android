package com.example.android_02_client;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SettingsActivity extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] settingsList = {"服务器设置", "代理服务器设置", "其它设置"};
		// 将菜单数组设置为listview的列表项展示
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, settingsList));
		getListView().setTextFilterEnabled(true);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		//Intent intent;
		switch (position) {
		case 0:
			
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		default:
			break;
		}
		super.onListItemClick(l, v, position, id);
	}

}
