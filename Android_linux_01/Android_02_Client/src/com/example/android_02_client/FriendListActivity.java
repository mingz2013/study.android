package com.example.android_02_client;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FriendListActivity extends ListActivity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		String[] friendsList = {"好友1", "好友2", "好友3"};
		// 将菜单数组设置为listview的列表项展示
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, friendsList));
		getListView().setTextFilterEnabled(true);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Intent intent;
		switch (position) {
		case 0:
			intent = new Intent(FriendListActivity.this, ChatActivity.class);
			startActivity(intent);
			break;
		case 1:
			intent = new Intent(FriendListActivity.this, ChatActivity.class);
			startActivity(intent);
			break;
		case 2:
			intent = new Intent(FriendListActivity.this, ChatActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}
		super.onListItemClick(l, v, position, id);
	}

	
	

}
