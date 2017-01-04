package com.example.appwidget04;



import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class ExampleAppWidgetProvider extends AppWidgetProvider{
	// 定义一个常量字符串,该常量用于命名action
	private static final String UPDATE_ACTION = "example.appwidget04.UPDATE_APP_WIDGET";
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
		String action = intent.getAction();
		if(UPDATE_ACTION.equals(action)){// 自己定义的action
			System.out.println("onReceive---->" + UPDATE_ACTION);
			// 得到remoteviews。代表了所有控件
			RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.example_appwidget);
			// 修改ImageView控件的资源文件
			remoteViews.setImageViewResource(R.id.imageId, R.drawable.girl);
			// 修改TextView的文本
			remoteViews.setTextViewText(R.id.widgetTextId, "test");
			// 得到appWidgetManager对象
			AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
			// Componentname 代表appwidget对象
			ComponentName componentName = new ComponentName(context, ExampleAppWidgetProvider.class);
			// 更新一下
			appWidgetManager.updateAppWidget(componentName, remoteViews);
		}
		else{// 系统自己的action
			super.onReceive(context, intent);
		}
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
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
