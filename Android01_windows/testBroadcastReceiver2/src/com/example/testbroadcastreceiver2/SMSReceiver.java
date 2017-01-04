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
		// 接收Intent对象当中的数据
		Bundle bundle = arg1.getExtras();
		// 在Bundle对象当中有一个属性，名为 pdus，这个属性的值是一个Object数组
		Object[] myOBJpdus = (Object[])bundle.get("pdus");
		// 创建一个smsMessage类型的数组
		SmsMessage[] messages = new SmsMessage[myOBJpdus.length];
		System.out.println(messages.length);
		for(int i = 0; i < myOBJpdus.length; i++)
		{
			// 使用Object数组当中的对象创建SMSMessage对象
			messages[i] = SmsMessage.createFromPdu((byte[])myOBJpdus[i]);
			// 调用smsmessage对象的getDisplayMessagebody方法就可以的到消息的内容
			System.out.println(messages[i].getDisplayMessageBody());
		}
	}

}
