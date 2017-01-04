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
		// 设置默认铃声
		mp = new MediaPlayer();
		try{
			mp.setDataSource(this, RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE));
			mp.prepare();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// 铃声响起
		mp.start();
		
		// 启动提示对话框，
		 new AlertDialog.Builder(AlarmAlert.this).setIcon(R.drawable.clock) 
         .setTitle("闹钟响了。。。").setMessage("快起床！！！") 
         .setPositiveButton("关闭", new DialogInterface.OnClickListener() { 

             @Override 
             public void onClick(DialogInterface dialog, int which) { 
                 // TODO Auto-generated method stub 
            	 // 这里销毁这个闹钟，闹钟不再响
                 //AlarmAlert.this.finish(); 
                 //mp.stop();
            	 AlarmManager alarmManager;
            	 alarmManager.cancel(pendingIntent);
            	 
             } 
         }).setPositiveButton("暂停", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				// 这里关闭对话框，停止响，然后等待重复响第二次
				AlarmAlert.this.finish(); 
                mp.stop();
				
			}
		}).show(); 

	}

}
