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
		/**��̬����ArrayAdapter
		List<String> list = new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		/**����ArrayAdapter�Ĺ��캯�������� ArrayAdapter����
		 * ��һ������ָ���������Ķ���
		 * �ڶ��������ƶ��������Ĳ˵���ÿһ����Ŀ����ʽ�������������Լ�д��һ�������ļ�
		 * �����������ƶ���textView�ؼ���ID��
		 * ���ĸ�����ָ���������б�����ݣ�list�п��Լ��κζ��������list�����е����ݵ���toString()�����õ����ַ�����ʾ��textView��
		ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, R.id.textViewId, list);
		*/
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(// ����һ��ArrayAdapter����
				this, 
				R.array.planets_array,	// string.xml�ж�������飬������Դ
				android.R.layout.simple_spinner_item	//�����ļ���android�Դ��ģ�Ĭ�ϵ������˵���ʽ��Ҳ���滻Ϊ�Լ�����Ĳ����ļ�
				);
		adapter.setDropDownViewResource(// ���������˵���ÿһ����Ŀ����ʽ
				android.R.layout.simple_spinner_dropdown_item	// android�Դ��Ĳ����ļ�������ÿһ��ѡ�����ʽ
				);
		spinner.setAdapter(adapter);
		spinner.setPrompt("����");	// ���ñ���
		// �󶨼�����
		spinner.setOnItemSelectedListener(new SpinnerOnSelectedListener());
		
		
	}
	// ����һ��������
	class SpinnerOnSelectedListener implements OnItemSelectedListener{

		// ���û�ѡ��ĳһ��Ŀʱ��������������
		public void onItemSelected(AdapterView<?> adapterView, View view, int position,
				long id) {
			// �õ�ѡ�е��ı�����
			String selected = adapterView.getItemAtPosition(position).toString();
			System.out.println(selected);
			
		}

		@Override// �û�ʲô��ûѡ
		public void onNothingSelected(AdapterView<?> arg0) {
			// TODO Auto-generated method stub
			System.out.println("nothingSelected");
			
		}
		
	}

	

}
