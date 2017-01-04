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
		// �½�����
		autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.outocomplete);
		//1.�ڲ����ļ���������һ��AutoCompleteTextView
		//2.��res/layout�ļ������½�һ�������ļ�����Ϊlist_item.xml
		//3.����һ��ArrayAdapter���ṩ����!DOCTYPE ��̬����
		List<String>list = new ArrayList<String>();
		list.add("testabc");
		list.add("testcde");
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, list);// �����listҲ���Դ���һ���ַ�������
		//4.ΪAutoCompleteTextView��������
		autoCompleteTextView.setAdapter(arrayAdapter);
	}



}
