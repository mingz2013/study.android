package com.example.alarm;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
// 重开机后重新计算并设置闹铃时间
public class BootReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
			// 重新计算闹铃时间，
			//并调第一步的方法设置闹铃时间及闹铃间隔时间
			
		}
	}
	

}
