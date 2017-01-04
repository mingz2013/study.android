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
	// 首先定义一个常量，该常量用于标识DatePickerDialog
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
			// 此方法用于显示DatePickerDialog对话框
			showDialog(DATE_PICKER_ID);
		}
	}
	
	// 创建对话框时的回调函数
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		switch (id) {
		case DATE_PICKER_ID:
			return new DatePickerDialog(this, onDateSetListener, 2013, 3, 16);// 设置显示的位置this，回调函数，年，月，日，// 月份是从0开始计数
		}
		return null;
		
	}

	// 监听器，用于监听用户点击set按钮，显示所设置的年月日信息
	DatePickerDialog.OnDateSetListener onDateSetListener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			System.out.println(year + "-" + (monthOfYear+1) + "-" + dayOfMonth);// 这里加一后显示的才是正确的
			
		}
	};

}
