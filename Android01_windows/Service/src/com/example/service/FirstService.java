package com.example.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FirstService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		System.out.println("Service onBind");
		return null;
	}
	// 当创建第一个Service对象之后，会首先调用这个函数
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("Service onCreate");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		System.out.println("Service onDestroy");
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		System.out.println("flags--->" + flags);
		System.out.println("startId--->" + startId);
		System.out.println("Service onStartCommand");
		return START_NOT_STICKY;
	}
	

}
