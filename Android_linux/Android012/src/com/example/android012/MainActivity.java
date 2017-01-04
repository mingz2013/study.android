package com.example.android012;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;


public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		String[] menus = {"查看电话信息", "编辑电话信息", "显示拨打电话界面", "直接拨打电话", "访问浏览器", "访问地图"};
		// 将菜单数组设置为listview的列表项展示
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menus));
		getListView().setTextFilterEnabled(true);
	}

	@Override
	// 响应列表单击事件
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		Uri uri;
		String data;
		switch (position) {
		// 查看id为1的用户电话信息
		case 0:
			// 字符串uri
			data = "content://contacts/people/1";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_VIEW);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		// 编辑id为1的用户电话信息
		case 1:
			// 字符串uri
			data = "content://contacts/people/1";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_EDIT);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		// 显示拨打电话界面
		case 2:
			// 字符串uri
			data = "tel:xxx";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_DIAL);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		// 直接拨打电话
		case 3:
			// 字符串uri
			data = "tel:xxx";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_CALL);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		// 访问浏览器
		case 4:
			// 字符串uri
			data = "http://www.baidu.com";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_VIEW);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		// 访问地图
		case 5:
			// 字符串uri
			data = "geo:39.92, 116.46";
			// 通过uri字符串获取uri实例
			uri = Uri.parse(data);
			// 设置intent的action属性
			intent.setAction(Intent.ACTION_VIEW);
			// 设置intent 的 data属性
			intent.setData(uri);
			// 启动activity
			startActivity(intent);
			break;
		default:
			break;
		}
		
		
		super.onListItemClick(l, v, position, id);
	}



}
