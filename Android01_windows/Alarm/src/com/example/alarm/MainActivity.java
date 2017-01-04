package com.example.alarm;

import java.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Intent;

public class MainActivity extends Activity {
	private Button dateButton, timeButton, startButton;
	private TextView dateTextView, timeTextView;
	// 常量，对话框类型
	private static final int TIMEPICKER = 0;
	private static final int DATEPICKER = 1;
	// 年月日 小时，分钟,秒,毫秒
	public int m_year, m_month, m_day;
	public int m_hour, m_minute, m_second, m_millisecond;
	// 日历
	private Calendar calendar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dateButton = (Button)findViewById(R.id.dateButtonId);
		dateButton.setOnClickListener(new DateButtonListener());
		
		timeButton = (Button)findViewById(R.id.timeButtonId);
		timeButton.setOnClickListener(new TimeButtonListener());
		
		startButton = (Button)findViewById(R.id.startButtonId);
		startButton.setOnClickListener(new StartButtonListener());
		
		timeTextView = (TextView)findViewById(R.id.timeTextViewId);
		dateTextView = (TextView)findViewById(R.id.dateTextViewId);
		// 获得日历实例
		calendar = Calendar.getInstance();
		flushTimeNow();
	}
	/**
	 * 更新全局变量和日期显示  为 当前系统时间
	 * 
	 * */
	private final void flushTimeNow(){
		// 设置时间为当前系统时间
		calendar.setTimeInMillis(System.currentTimeMillis());
		// 获得年月日 小时 分钟 秒 毫秒
		m_year = calendar.get(Calendar.YEAR);
		m_month = calendar.get(Calendar.MONTH);
		m_day = calendar.get(Calendar.DAY_OF_MONTH);
		m_hour = calendar.get(Calendar.HOUR);
		m_minute = calendar.get(Calendar.MINUTE);
		m_second = calendar.get(Calendar.SECOND);
		m_millisecond = calendar.get(Calendar.MILLISECOND);
		// 显示日期 时间
		dateTextView.setText(m_year + "/" + (m_month + 1) + "/" + m_day);
		timeTextView.setText(m_hour + ":" + m_minute + ":" + m_second);
	}
	private class DateButtonListener implements OnClickListener{

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			showDialog(DATEPICKER);
		}
		
	}
	private class TimeButtonListener implements OnClickListener{

		@SuppressWarnings("deprecation")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			showDialog(TIMEPICKER);
			
		}
		
	}
	private class StartButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			// 取得设置后的时间
			calendar.set(Calendar.YEAR, m_year);
			calendar.set(Calendar.MONTH, m_month);
			calendar.set(Calendar.DAY_OF_MONTH, m_day);
			calendar.set(Calendar.HOUR, m_hour);
			calendar.set(Calendar.MINUTE, m_minute);
			calendar.set(Calendar.SECOND, m_second);
			calendar.set(Calendar.MILLISECOND, m_millisecond);
			// 指定闹钟设置时间到时要运行 CallAlarm.class
			Intent intent = new Intent(MainActivity.this, CallAlarm.class);
			// 创建PendingIntent
			PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
			// AlarmManager.POWER_OFF_WAKEUP	设置服务在系统关机状态下也可以唤醒系统
			AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			// 重复响，一分钟响一次
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60*1000, sender);
			// 响一次
			//alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
		
		}
		
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		// 不能设置在这里更新时间，在这里更新时间，只更新一次，这里是创建，创建后不销毁
		switch (id) {
		case TIMEPICKER:
			return new TimePickerDialog(this, onTimeSetListener, m_hour, m_minute, true);
		case DATEPICKER:
			return new DatePickerDialog(this, onDateSetListener, m_year, m_month, m_day);
		default:
			return null;
		}
	}
	TimePickerDialog.OnTimeSetListener onTimeSetListener = new OnTimeSetListener() {
		
		@Override
		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			// TODO Auto-generated method stub
			m_hour = hourOfDay;
			m_minute = minute;
			m_second = 0;
			m_millisecond = 0;
			timeTextView.setText(m_hour + ":" + m_minute + ":" + m_second);
		}
	};
	DatePickerDialog.OnDateSetListener onDateSetListener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			// TODO Auto-generated method stub
			m_year = year;
			m_month = monthOfYear;
			m_day = dayOfMonth;
			dateTextView.setText(m_year + "/" + (m_month + 1) + "/" + m_day);
		}
	};
}
