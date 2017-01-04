package com.example.expandablelistactivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.os.Bundle;
import android.app.ExpandableListActivity;
import android.widget.SimpleExpandableListAdapter;
/**
 * ����һ��Activity,�̳�ExpandableListActivity
 * 
 * */ 
public class MainActivity extends ExpandableListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// ����һ��List,��list����Ϊһ����Ŀ�ṩ����
		List<Map<String, String>> groups = new ArrayList<Map<String, String>>();
		Map<String, String> group1 = new HashMap<String, String>();
		group1.put("group", "group1");
		Map<String, String> group2 = new HashMap<String, String>();
		group2.put("group", "group2");
		groups.add(group1);
		groups.add(group2);
		// ����һ��list���ö���Ϊ��һ��һ����Ŀ�ṩ������Ŀ������
		List<Map<String, String>> child1 = new ArrayList<Map<String,String>>();
		Map<String, String> child1Data1 = new HashMap<String, String>();
		child1Data1.put("child", "childData1");
		child1.add(child1Data1);
		Map<String, String> child1Data2 = new HashMap<String, String>();
		child1Data2.put("child", "childData2");
		child1.add(child1Data2);
		// ����һ��list,��list����Ϊ�ڶ���һ����Ŀ�ṩ������Ŀ�Ķ���
		List<Map<String, String>> child2 = new ArrayList<Map<String,String>>();
		Map<String, String> child2Data1 = new HashMap<String, String>();
		child2Data1.put("child", "child2Data1");
		child2.add(child2Data1);
		// ����һ��list����list�������ڴ�����еĶ�����Ŀ������
		List<List<Map<String, String>>> childs = new ArrayList<List<Map<String,String>>>();
		childs.add(child1);
		childs.add(child2);
		/** 
		 * ����һ��SimpleExpandableListAdapter����
		 * 1.context
		 * 2.һ����Ŀ������
		 * 3.һ����Ŀ��ʽ�����ļ�
		 * 4.ָ��һ����Ŀ���ݵ�key
		 * 5.ָ��һ����Ŀ������ʾ�ؼ���ID
		 * 6.ָ��������Ŀ������
		 * 7.�������ö�����Ŀ��ʽ�Ĳ����ļ�
		 * 8.ָ��������Ŀ���ݵ�key
		 * 9.ָ��������Ŀ������ʾ�ؼ���ID
		 */
		SimpleExpandableListAdapter sela = new SimpleExpandableListAdapter(this, groups, R.layout.group, new String[]{"group"}, new int[]{R.id.groupTo}, childs, R.layout.child, new String[]{"child"}, new int[]{R.id.childTo});
		// ��SimpleExpadableListAdapter�������ø���ǰ��ExpadableListActivity
		setListAdapter(sela);
		
		
		
		
		
	}


}
