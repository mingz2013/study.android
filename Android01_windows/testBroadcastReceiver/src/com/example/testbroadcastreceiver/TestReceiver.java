package com.example.testbroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class TestReceiver extends BroadcastReceiver{
	public TestReceiver(){
		System.out.println("testreceiver");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("onReveive");
	}
	
}
