package com.example.android018;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Log.i("my_tag", "BOOT_COMPLETED....");
		Toast.makeText(arg0, "BOOT_COMPLETED....", Toast.LENGTH_LONG).show();
		
	}

}
