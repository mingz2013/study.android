package com.example.alarm;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
// �ؿ��������¼��㲢��������ʱ��
public class BootReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String action = intent.getAction();
		if(action.equals(Intent.ACTION_BOOT_COMPLETED)){
			// ���¼�������ʱ�䣬
			//������һ���ķ�����������ʱ�估������ʱ��
			
		}
	}
	

}
