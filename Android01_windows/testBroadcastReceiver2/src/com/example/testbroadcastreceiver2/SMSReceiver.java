package com.example.testbroadcastreceiver2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;

@SuppressWarnings("deprecation")
public class SMSReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		System.out.println("receive message");
		// ����Intent�����е�����
		Bundle bundle = arg1.getExtras();
		// ��Bundle��������һ�����ԣ���Ϊ pdus��������Ե�ֵ��һ��Object����
		Object[] myOBJpdus = (Object[])bundle.get("pdus");
		// ����һ��smsMessage���͵�����
		SmsMessage[] messages = new SmsMessage[myOBJpdus.length];
		System.out.println(messages.length);
		for(int i = 0; i < myOBJpdus.length; i++)
		{
			// ʹ��Object���鵱�еĶ��󴴽�SMSMessage����
			messages[i] = SmsMessage.createFromPdu((byte[])myOBJpdus[i]);
			// ����smsmessage�����getDisplayMessagebody�����Ϳ��Եĵ���Ϣ������
			System.out.println(messages[i].getDisplayMessageBody());
		}
	}

}
