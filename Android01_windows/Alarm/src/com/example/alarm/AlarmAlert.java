package com.example.alarm;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.os.Bundle;

public class AlarmAlert extends Activity{
	private MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ����Ĭ������
		mp = new MediaPlayer();
		try{
			mp.setDataSource(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
			mp.prepare();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// ��������
		mp.start();
		
		// ������ʾ�Ի���
		 new AlertDialog.Builder(AlarmAlert.this).setIcon(R.drawable.clock) 
         .setTitle("�������ˡ�����").setMessage("���𴲣�����") 
         .setPositiveButton("�ر�", new DialogInterface.OnClickListener() { 

             @Override 
             public void onClick(DialogInterface dialog, int which) { 
                 // TODO Auto-generated method stub 
            	 // ��������������ӣ����Ӳ�����
                 //AlarmAlert.this.finish(); 
                 //mp.stop();
            	 AlarmManager alarmManager;
            	 alarmManager.cancel(pendingIntent);
            	 
             } 
         }).setPositiveButton("��ͣ", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// ����رնԻ���ֹͣ�죬Ȼ��ȴ��ظ���ڶ���
				AlarmAlert.this.finish(); 
                mp.stop();
				
			}
		}).show(); 

	}

}
