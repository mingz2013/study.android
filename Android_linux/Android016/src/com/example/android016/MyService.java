package com.example.android016;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		Log.i("SERVICE", "Onbind.....！");
		Toast.makeText(MyService.this, "onBInd...", Toast.LENGTH_LONG).show();
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.i("SERVICE", "Oncreate.....！");
		Toast.makeText(MyService.this, "oncreate...", Toast.LENGTH_LONG).show();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.i("SERVICE", "Ondestroy.....！");
		Toast.makeText(MyService.this, "ondestroy...", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Log.i("SERVICE", "Onstart.....！");
		Toast.makeText(MyService.this, "onstart...", Toast.LENGTH_LONG).show();
		super.onStart(intent, startId);
	}

}
