package com.example.animations06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ListActivity {
	private Button button = null;
	private ListView listView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = getListView();
		button = (Button)findViewById(R.id.buttonId);
		button.setOnClickListener(new buttonListener());
		
		
		
	}
	private ListAdapter buildListAdapter() {
		List<HashMap<String, String>> list = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> m1 = new HashMap<String, String>();
		m1.put("user_name", "zhangsan");
		m1.put("user_gender", "nv");
		
		HashMap<String, String> m2 = new HashMap<String, String>();
		m2.put("user_name", "lisi");
		m2.put("user_gender", "nv");
		
		HashMap<String, String> m3 = new HashMap<String, String>();
		m3.put("user_name", "wangwu");
		m3.put("user_gender", "nan");
		
		list.add(m1);
		list.add(m2);
		list.add(m3);
		
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.item, new String[]{"user_name", "user_gender"}, new int[]{R.id.user_name, R.id.user_gender});
		return simpleAdapter;
	}
	
	
	private class buttonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			listView.setAdapter(buildListAdapter());
			
			// 下面是代码实现方法
			Animation animation = (Animation)AnimationUtils.loadAnimation(MainActivity.this, R.anim.list_anim);
			LayoutAnimationController lac = new LayoutAnimationController(animation);
			lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
			lac.setDelay(0.5f);
			listView.setLayoutAnimation(lac);
			
		}
		
	}



}
