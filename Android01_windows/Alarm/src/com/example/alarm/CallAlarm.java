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
			//��1�������õ�����ʱ�䵽��������Ե���������ʾ
	        
			Intent i = new Intent(context, AlarmAlert.class); 
	        Bundle bundleRet = new Bundle(); 
	        bundleRet.putString("SRC_CALLER", ""); 
	        i.putExtras(bundleRet); 
	        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 
	        context.startActivity(i);
	      //���Լ���������һ������ʱ��;
	        
		}
	}

}
