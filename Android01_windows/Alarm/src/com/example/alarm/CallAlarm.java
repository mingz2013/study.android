package com.example.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class CallAlarm extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		
		if("com.example.alarm.action".equals(intent.getAction())){
			//第1步中设置的闹铃时间到，这里可以弹出闹铃提示
	        
			Intent i = new Intent(context, AlarmAlert.class); 
	        Bundle bundleRet = new Bundle(); 
	        bundleRet.putString("SRC_CALLER", ""); 
	        i.putExtras(bundleRet); 
	        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	        context.startActivity(i);
	      //可以继续设置下一次闹铃时间;
	        
		}
	}

}
