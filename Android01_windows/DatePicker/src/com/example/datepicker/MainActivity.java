package com.example.datepicker;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class MainActivity extends Activity {
	private Button showDatePickerButton = null;
	// ���ȶ���һ���������ó������ڱ�ʶDatePickerDialog
	private static final int DATE_PICKER_ID = 1; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		showDatePickerButton = (Button)findViewById(R.id.showdatepickerbutton);
		showDatePickerButton.setOnClickListener(new ShowDatePickerButtonListener());
	}
	private class ShowDatePickerButtonListener implements OnClickListener{

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// �˷���������ʾDatePickerDialog�Ի���
			showDialog(DATE_PICKER_ID);
		}
	}
	
	// �����Ի���ʱ�Ļص�����
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case DATE_PICKER_ID:
			return new DatePickerDialog(this, onDateSetListener, 2013, 3, 16);// ������ʾ��λ��this���ص��������꣬�£��գ�// �·��Ǵ�0��ʼ����
		}
		return null;
		
	}

	// �����������ڼ����û����set��ť����ʾ�����õ���������Ϣ
	DatePickerDialog.OnDateSetListener onDateSetListener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			System.out.println(year + "-" + (monthOfYear+1) + "-" + dayOfMonth);// �����һ����ʾ�Ĳ�����ȷ��
			
		}
	};

}
