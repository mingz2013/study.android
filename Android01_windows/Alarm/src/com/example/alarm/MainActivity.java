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
	// �������Ի�������
	private static final int TIMEPICKER = 0;
	private static final int DATEPICKER = 1;
	// ������ Сʱ������,��,����
	public int m_year, m_month, m_day;
	public int m_hour, m_minute, m_second, m_millisecond;
	// ����
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
		// �������ʵ��
		calendar = Calendar.getInstance();
		flushTimeNow();
	}
	/**
	 * ����ȫ�ֱ�����������ʾ  Ϊ ��ǰϵͳʱ��
	 * 
	 * */
	private final void flushTimeNow(){
		// ����ʱ��Ϊ��ǰϵͳʱ��
		calendar.setTimeInMillis(System.currentTimeMillis());
		// ��������� Сʱ ���� �� ����
		m_year = calendar.get(Calendar.YEAR);
		m_month = calendar.get(Calendar.MONTH);
		m_day = calendar.get(Calendar.DAY_OF_MONTH);
		m_hour = calendar.get(Calendar.HOUR);
		m_minute = calendar.get(Calendar.MINUTE);
		m_second = calendar.get(Calendar.SECOND);
		m_millisecond = calendar.get(Calendar.MILLISECOND);
		// ��ʾ���� ʱ��
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
			// ȡ�����ú��ʱ��
			calendar.set(Calendar.YEAR, m_year);
			calendar.set(Calendar.MONTH, m_month);
			calendar.set(Calendar.DAY_OF_MONTH, m_day);
			calendar.set(Calendar.HOUR, m_hour);
			calendar.set(Calendar.MINUTE, m_minute);
			calendar.set(Calendar.SECOND, m_second);
			calendar.set(Calendar.MILLISECOND, m_millisecond);
			// ָ����������ʱ�䵽ʱҪ���� CallAlarm.class
			Intent intent = new Intent(MainActivity.this, CallAlarm.class);
			// ����PendingIntent
			PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
			// AlarmManager.POWER_OFF_WAKEUP	���÷�����ϵͳ�ػ�״̬��Ҳ���Ի���ϵͳ
			AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
			// �ظ��죬һ������һ��
			alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 60*1000, sender);
			// ��һ��
			//alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
		
		}
		
	}
	
	@Override
	protected Dialog onCreateDialog(int id) {
		// TODO Auto-generated method stub
		// �����������������ʱ�䣬���������ʱ�䣬ֻ����һ�Σ������Ǵ���������������
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
