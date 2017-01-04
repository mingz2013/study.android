package com.example.testbroadcastreceiver2;

import android.os.Bundle;
import android.app.Activity;
import android.content.IntentFilter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button registerButton = null;
	private Button unregisterButton = null;
	private SMSReceiver smsReceiver = null;
	
	private static final String SMS_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		registerButton = (Button)findViewById(R.id.register);
		unregisterButton = (Button)findViewById(R.id.unregister);
		registerButton.setOnClickListener(new RegisterReceiverListener());
		unregisterButton.setOnClickListener(new UnRegisterReceiverListener());
	}
	class RegisterReceiverListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// ����һ��BroadcastReceiver����
			smsReceiver = new SMSReceiver();
			// ����һ�� IntentFilter ����
			IntentFilter filter = new IntentFilter();
			// ΪIntentFilter���һ��Action
			filter.addAction(SMS_ACTION);
			// ��BroadcastReceiver����ע�ᵽϵͳ����
			MainActivity.this.registerReceiver(smsReceiver, filter);
		}
	}
	class UnRegisterReceiverListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// ��� ע��
			MainActivity.this.unregisterReceiver(smsReceiver);
		}
		
	}



}
