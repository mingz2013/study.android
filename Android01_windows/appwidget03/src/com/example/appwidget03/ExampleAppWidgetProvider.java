package com.example.appwidget03;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider {
	// 定义一个常量字符串,该常量用于命名action
	private static final String UPDATE_ACTION = "example.appwidget03.UPDATE_APP_WIDGET";
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
	}

	@Override
	public void onDisabled(Context context) {
		// TODO Auto-generated method stub
		super.onDisabled(context);
	}

	@Override
	public void onEnabled(Context context) {
		// TODO Auto-generated method stub
		super.onEnabled(context);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		String action = intent.getAction();
		if(UPDATE_ACTION.equals(action)){
			System.out.println("onReceive---->" + UPDATE_ACTION);
		}
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// 创建一个Intent对象
		Intent intent = new Intent();
		// 为Intent对象设置action
		intent.setAction(UPDATE_ACTION);
		// 使用getBroadcast方法得到一个PendingIntent对象,当该对象执行时,会发送一个广播
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
		// 得到RemoteViews,并绑定事件
		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
		remoteViews.setOnClickPendingIntent(R.id.widgetbuttonId, pendingIntent);
		// 更新一下
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
		
	}

}
